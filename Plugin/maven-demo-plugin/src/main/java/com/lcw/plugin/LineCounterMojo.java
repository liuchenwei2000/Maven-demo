package com.lcw.plugin;

import org.apache.maven.model.Resource;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.*;
import java.util.List;

/**
 * <p>用于代码行统计的 Maven 插件</p>
 * 使用 mvn clean install 命令将该插件项目构建并安装到本地仓库后，
 * 就可以使用它统计 Maven 项目的代码行了。
 *
 * @author liuchenwei
 * @date 2015/12/29
 */
// 通过 @Mojo 注解使得 Maven 能自动识别该目标（goal）
// name 属性用来指定目标名，defaultPhase 属性默认将该目标绑定至生命周期的某个阶段。
@Mojo(name = "linecount", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class LineCounterMojo extends AbstractMojo// 必需继承自 AbstractMojo
{
    /**
     * 默认统计行数的文件类型
     */
    private static final String[] INCLUDES_DEFAULT = {"java", "xml"};

    // @Parameter 表明该属性是可配置的，defaultValue 是默认值，可以引用 maven 属性
    @Parameter(defaultValue = "${project.basedir}", readonly = true, required = true)
    private File baseDir;

    @Parameter(defaultValue = "${project.build.sourceDirectory}", readonly = true, required = true)
    private File sourceDirectory;

    @Parameter(defaultValue = "${project.build.testSourceDirectory}", readonly = true, required = true)
    private File testSourceDirectory;

    @Parameter(defaultValue = "${project.build.resources}", readonly = true, required = true)
    private List<Resource> resources;

    @Parameter(defaultValue = "${project.build.testResources}", readonly = true, required = true)
    private List<Resource> testResources;

    // 需要统计行数的文件类型
    @Parameter
    private String[] includes;

    private FileFilter fileFilter;

    /**
     * 插件类需要实现该方法以执行具体行为
     */
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException
    {
        if (includes == null)
        {
            includes = INCLUDES_DEFAULT;
        }

        this.fileFilter = new CompositeFileFilter(includes);

        try
        {
            countDir(sourceDirectory);

            countDir(testSourceDirectory);

            for (Resource resource : resources)
            {
                countDir(new File(resource.getDirectory()));
            }

            for (Resource resource : testResources)
            {
                countDir(new File(resource.getDirectory()));
            }

        } catch (IOException e)
        {
            throw new MojoExecutionException("Unable to count lines of code", e);
        }
    }

    private void countDir(File dir) throws IOException
    {
        String path = dir.getAbsolutePath().substring(baseDir.getAbsolutePath().length());
        int lines = count(dir);
        // getLog() 得到一个日志对象，可以用来输出日志到 Maven 命令行。
        getLog().info(path + " : " + lines + " lines.");
    }

    private int count(File file) throws IOException
    {
        if (file.isFile())
        {
            return countFile(file);
        } else
        {
            int total = 0;
            File[] files = file.listFiles();
            if(files != null)
            {
                for (File f : files)
                {
                    total += count(f);
                }
            }
            return total;
        }
    }

    private int countFile(File file) throws IOException
    {
        int lines = 0;
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null)
            {
                if (s.trim().length() > 1)
                {
                    lines++;
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            if (br != null)
            {
                br.close();
            }
        }
        return lines;
    }

    private static class CompositeFileFilter implements FileFilter
    {
        private String[] fileTypes;

        public CompositeFileFilter(String... fileType)
        {
            this.fileTypes = fileType;
        }

        @Override
        public boolean accept(File file)
        {
            if (file.isDirectory())
            {
                return true;
            }

            String filePath = file.getName().toLowerCase();
            if (fileTypes != null)
            {
                for (String fileType : fileTypes)
                {
                    String surffix = "." + fileType;
                    if (filePath.endsWith(surffix))
                    {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

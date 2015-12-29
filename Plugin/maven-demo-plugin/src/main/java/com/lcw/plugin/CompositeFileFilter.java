package com.lcw.plugin;

import java.io.File;
import java.io.FileFilter;

/**
 * <p>组合文件过滤器</p>
 * 可以用来过滤多种类文件。
 *
 * @author liuchenwei
 * @date 2015/12/29
 */
public class CompositeFileFilter implements FileFilter
{
    // 文件类型数组
    private String[] fileTypes;

    public CompositeFileFilter(String... fileTypes)
    {
        this.fileTypes = fileTypes;
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
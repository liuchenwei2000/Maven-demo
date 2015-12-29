package com.lcw.plugin;

import java.io.*;

/**
 * <p>行计数器</p>
 * 可以用来统计某指定目录下所有文件数和行数。
 *
 * @author liuchenwei
 * @date 2015/12/29
 */
public class LineCounter {

	private File dir;// 指定文件夹

	private int files = 0;// 总文件数
	private int lines = 0;// 总行数

    private FileFilter fileFilter;// 指定文件过滤器

	/**
	 * @param dir 指定目录
	 */
	public LineCounter(String dir)
	{
		this.dir = new File(dir);
	}

    /**
     * @param dir 指定目录
     */
    public LineCounter(File dir)
    {
        this.dir = dir;
    }

    /**
     * 设置文件过滤器
     *
     * @param fileFilter 文件过滤器
     */
    public void setFileFilter(FileFilter fileFilter)
    {
        this.fileFilter = fileFilter;
    }

    /**
	 * @return 总文件数
	 */
	public int getFiles()
	{
		return files;
	}

	/**
	 * @return 总行数
	 */
	public int getLines()
	{
		return lines;
	}

	/**
	 * 开始统计
	 */
	public void start() throws IOException
	{
        if(dir.exists()){
            count(dir);
        }
	}

	private void count(File file) throws IOException
	{
		if (file.isFile())
		{
			files++;
			countFile(file);
		} else
		{
            File[] files = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
            if (files != null)
            {
                for (File f : files)
                {
                    count(f);
                }
            }
        }
	}

	private void countFile(File file) throws IOException
	{
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
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        LineCounter counter = new LineCounter("src");
        try
        {
            counter.start();
            System.out.println("total files:" + counter.getFiles());
            System.out.println("total lines:" + counter.getLines());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
	}
}

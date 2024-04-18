package com.example.demo.springutil;

import org.springframework.core.io.UrlResource;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;


/**
 * classLoader
 */
public class ClassLoaderTest
{

    public static final String FILE_NAME = "ceshi/ceshi.txt";

    public static void main(String[] args)
        throws IOException
    {
        testClassLoader();
    }

    /**
     * {@link ClassUtils#getDefaultClassLoader()}
     * 器 获取默认的类加载，即当前线程的类加载器，通常在程序中拿到的都是AppClassLoader
     * <br>
     * {@link StringUtils#delimitedListToStringArray(String, String)}
     * 将字符串按照指定的分隔符分割，并将结果封装成数组进行返回
     */
    public static void testClassLoader()
        throws IOException
    {
        // 获取默认的类加载器
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        // 获取到需要加载的文件所在的所有url
        Enumeration<URL> urls = (classLoader != null ?
            classLoader.getResources(FILE_NAME) :
            ClassLoader.getSystemResources(FILE_NAME));
        // 遍历获取到的文件url信息
        while (urls.hasMoreElements())
        {
            // 封装对应的url信息
            URL url = urls.nextElement();
            UrlResource resource = new UrlResource(url);
            // 解析文件信息
            File file = resource.getFile();
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String s = fileReader.readLine();
            // 将读取到的字符串按照","分割，并返回一个字符数组
            String[] strArr = StringUtils.delimitedListToStringArray(s, ",");
            for (String s1 : strArr)
            {
                System.out.println(s1);
            }
        }
    }
}

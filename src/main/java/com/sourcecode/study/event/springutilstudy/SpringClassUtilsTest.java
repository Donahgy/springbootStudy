package com.sourcecode.study.event.springutilstudy;

import org.springframework.util.ClassUtils;


/**
 * {@link ClassUtils}
 */
public class SpringClassUtilsTest
{

    public static void main(String[] args)
    {
        System.out.println(testIsPresentMethod());
    }

    /**
     * {@link ClassUtils#isPresent(String, ClassLoader)}
     * 判断提供的名称所对应的类是否存在并且可以呗加载，如果类或其依赖项之一不存在或无法加载，则返回false。否则就会通过反射去加载对应的类
     *
     *  第一个参数为：需要被检查的全限定类名
     * 第二个参数为：需要用到的类加载器
     */
    public static boolean testIsPresentMethod()
    {
        // 判断"com.example.demo.springutil.SpringClassUtilsTest"对应的类是否存在并且是否可以被加载，当类可以被加载时
        // 则直接使用指定的类加载器去加载对应的类并返回true，否则返回false，classLoader为空时，默认使用AppClassLoader即应
        // 用程序类加载器
        return ClassUtils.isPresent("com.example.demo.springutil.SpringClassUtilsTest",null);
    }
}

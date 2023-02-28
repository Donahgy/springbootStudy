package com.example.demo.classloader;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestClassLoader {
    static class MyClassLoader extends ClassLoader{
        private String classPath;

        public MyClassLoader(String classPath)
        {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception
        {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name
                    + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                return defineClass(name,data,0,data.length);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader("C:/study");
        Class<?> clazz = myClassLoader.loadClass("com.pandong.classloader.User");
        Object instance = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sout", null);
        method.invoke(instance,null);
        System.out.println(clazz.getClassLoader().getClass().getName());

    }
}

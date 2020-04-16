package basics.classload;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

//获取当前类的Classloader
//clazz.getClassLoader()
//获取当前线程的上下文的classLoader
//Thread.currentThread().getContextClassLoader()
//获取系统ClassLoader
//ClassLoader.getSystemClassLoader()
//获取调用者的ClassLoader
//DriverManager.getCallerClassLoader()
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        String resourceName="Interview/jdk/MyTest13.class";
        Enumeration<URL>urls=classLoader.getResources(resourceName);
        while (urls.hasMoreElements()){
            URL url=urls.nextElement();
            System.out.println(url);
        }
        System.out.println("----------");
        Class<?>clazz=MyTest14.class;
        System.out.println(clazz.getClassLoader());
        System.out.println("----------");
        Class<?>clazz1=String.class;
        System.out.println(clazz1.getClassLoader());
    }
}

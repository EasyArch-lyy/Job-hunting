package basics.classload;

/**
 * @author lyy
 */
public class MyTest7 {
    
    public static void main(String[] args) throws ClassNotFoundException {
        //某些类加载器使用根加载器，getClassLoader()返回NULL
        Class<?> clazz = Class.forName("java.lang.String");
        //输出null
        System.out.println(clazz.getClassLoader());
        Class<?> clazz2 = Class.forName("Interview.jdk.C");
        System.out.println(clazz2.getClassLoader());
        //sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}

class C{

}
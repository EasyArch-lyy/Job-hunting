package basics.classload;

class CL{
    static {
        System.out.println("Class CL");
    }
}

//调用ClassLoader类的loadClass方法加载一个类，不是对类的主动使用，不会使类加载
public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        //未导致初始化
        Class<?>clazz=classLoader.loadClass("Interview.jdk.CL");
        System.out.println(clazz);
        System.out.println("---------");
        //反射
        clazz=Class.forName("Interview.jdk.CL");
        System.out.println(clazz);
    }
}

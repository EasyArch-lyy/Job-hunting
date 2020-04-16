package basics.reflex.proxy.test.proxy;

import sun.misc.ProxyGenerator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author lyy
 */
public class Client {
    public static void main(String[] args) throws IOException {

        /**我们要代理的真实对象*/
        Subject realSubject = new SubjectImpl();
        /**我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的*/
        InvocationHandler handler = new DynamicProxy(realSubject);

        /**
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), handler);

        byte[] bytes = ProxyGenerator.generateProxyClass(subject.getClass().getName(), realSubject.getClass().getInterfaces());
        File dir = new File("/home/lyy/桌面/Job-hunting/src/main/java/basics.reflex/" + File.separator + "testJ.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(dir);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();
        fileOutputStream.close();
        System.out.println(subject.getClass().getName());
        subject.rent();
        subject.hello("world");
    }
}

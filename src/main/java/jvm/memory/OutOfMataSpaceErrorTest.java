package jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 元空间内存溢出测试
 * 设置元空间大小：-XX:MaxMetaspaceSize=100m
 *
 * @author lyy
 */
public class OutOfMataSpaceErrorTest {
    public static void main(String[] args) {
        //使用动态代理动态生成类
        while (true){
            Enhancer enhancer=new Enhancer();
            enhancer.setSuperclass(OutOfMataSpaceErrorTest.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(obj,method,ags,proxy)->proxy.invokeSuper(obj,ags));
            // java.lang.OutOfMemoryError: Metaspace
            enhancer.create();
            System.out.println("Hello World");
        }
    }
}
//Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
//	at java.lang.Class.forName0(Native Method)
//	at java.lang.Class.forName(Class.java:348)
//	at net.sf.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:467)
//	at net.sf.cglib.core.AbstractClassGenerator.generate(AbstractClassGenerator.java:339)
//	at net.sf.cglib.proxy.Enhancer.generate(Enhancer.java:492)
//	at net.sf.cglib.core.AbstractClassGenerator$ClassLoaderData.get(AbstractClassGenerator.java:117)
//	at net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:294)
//	at net.sf.cglib.proxy.Enhancer.createHelper(Enhancer.java:480)
//	at net.sf.cglib.proxy.Enhancer.create(Enhancer.java:305)
//	at jvm.memory.OutOfMataSpaceErrorTest.main(OutOfMataSpaceErrorTest.java:22)
//
//Process finished with exit code 1
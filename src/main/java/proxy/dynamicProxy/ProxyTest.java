package proxy.dynamicProxy;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lyy
 */
public class ProxyTest {

    public static void main(String[] args) {
        Person zhanglong=new Student("张龙");

        InvocationHandler stuhandler=new StuInvocationHandler<Person>(zhanglong);

        Person stuProxy= (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),new Class<?>[]{Person.class},stuhandler);

        stuProxy.giveMoney();
    }
}

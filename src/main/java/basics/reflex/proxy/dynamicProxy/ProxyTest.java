package basics.reflex.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

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

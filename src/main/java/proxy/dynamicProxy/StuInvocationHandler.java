package proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lyy
 */
public class StuInvocationHandler<T>implements InvocationHandler {

    T target;

    public StuInvocationHandler(T target){
        this.target=target;
    }

   /**
    * @param proxy 动态代理对象
    * @param method 正在执行的方法
    * @param args 调用目标方法传入的参数
    */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行"+method.getName()+"方法");
        MonitorUtil.start();
        Object result=method.invoke(target,args);
        MonitorUtil.finish(method.getName());
        return result;
    }
}

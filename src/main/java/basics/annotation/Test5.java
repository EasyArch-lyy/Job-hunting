package basics.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lyy
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TestAble{
}

class Processor{
    public static void process(String clazz)throws ClassNotFoundException{
        int passed=0;
        int failed=0;
        for(Method m:Class.forName(clazz).getMethods()){
            if(m.isAnnotationPresent(TestAble.class)){
                try {
                    m.invoke(null);
                    passed++;
                } catch (Exception e) {
                    System.out.println("方法"+m+"运行失败异常:"+e.getCause());
                    failed++;
                }
            }
        }
        // 统计测试结果
        System.out.println("共运行了:" + (passed + failed)
                + "个方法，其中：\n" + "失败了:" + failed + "个，\n"
                + "成功了:" + passed + "个！");
    }
}
/**
 * @author lyy
 */
public class Test5 {
    @TestAble
    public static void m1(){
        System.out.println("m1");
    }

    public static void m2(){
        System.out.println("m2");
    }

    @TestAble
    public static void m3(){
        System.out.println("m3");
        throw new IllegalArgumentException("参数出错");
    }

    @TestAble
    public static void m4(){
        System.out.println("m4");
    }

    @TestAble
    public static void m5(){
        System.out.println("m5");
    }

    @TestAble
    public static void m6(){
        System.out.println("m6");
    }

    @TestAble
    public static void m7(){
        System.out.println("m7");
        throw new RuntimeException("业务出错");
    }

    public static void m8(){
        System.out.println("m8");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Processor.process("basics.annotation.Test5");
    }

}

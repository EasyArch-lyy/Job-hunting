package basics.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lyy
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Annotation{
    String value();
    String color()default "rea";
    String[]value1()default {"abc","aaa"};
}
/**
 * @author lyy
 */
@Annotation(value = "java",value1 = {"aaa","bbb"})
public class Test6 {
    public static void main(String[] args) {
        // 判断此类上是否存在指定的注解类
        if(Test6.class.isAnnotationPresent(Annotation.class)){
            Annotation annotation=(Annotation)Test6.class.getAnnotation(Annotation.class);
            System.out.println("value="+annotation.value());
            System.out.println("color="+annotation.color());
            String[] strs=annotation.value1();
            for(String str:strs){
                System.out.println(str);
            }
        }
    }
}

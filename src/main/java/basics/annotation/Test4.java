package basics.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@interface Testable
{
}
/**
 * 注解表明这个注解应该被 javadoc工具记录. 默认情况下,javadoc是不包括注解的. 但如果声明注解时指定了 @Documented,则它会被 javadoc 之类的工具处理, 所以注解类型信息也会被包括在生成的文档中
 * @author lyy
 */
public class Test4 {

    @Testable
    public void info(){
        System.out.println("info方法...");
    }

    public static void main(String[] args) {
        Test4 test4=new Test4();
        test4.info();
    }
}

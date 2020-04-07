package basics.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface InInheritable
{
}

@InInheritable
class Base{

}
/**
 * @author lyy
 */
public class Test3 extends Base{
    public static void main(String[] args) {
        System.out.println(Test3.class.isAnnotationPresent(InInheritable.class));
    }
}
////@Retention: 定义注解的保留策略
////@Retention(RetentionPolicy.SOURCE)    //注解仅存在于源码中，在class字节码文件中不包含
////@Retention(RetentionPolicy.CLASS)     // 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得，
////@Retention(RetentionPolicy.RUNTIME)   // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
//
////@Target：定义注解的作用目标
////@Target(ElementType.TYPE)             // 接口、类、枚举、注解
////@Target(ElementType.FIELD)            // 字段、枚举的常量
////@Target(ElementType.METHOD)           // 方法
////@Target(ElementType.PARAMETER)        // 方法参数
////@Target(ElementType.CONSTRUCTOR)      // 构造函数
////@Target(ElementType.LOCAL_VARIABLE)   // 局部变量
////@Target(ElementType.ANNOTATION_TYPE)  // 注解
////@Target(ElementType.PACKAGE)          // 包
//
////@Document：说明该注解将被包含在javadoc中
//
////@Inherited：说明子类可以继承父类中的该注解
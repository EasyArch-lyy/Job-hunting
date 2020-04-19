package basics.new1_8;


/**
 * Lambda表达式实例2
 * 变量作用域
 * basics.new1_8.lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 basics.new1_8.lambda 内部修改定义在域外的局部变量，否则会编译错误。
 *
 * @author lyy
 */
public class Java8Tester3 {

    final static String salutation = "Hello! ";

    public static void main(String args[]){
        GreetingService greetService1 = message -> System.out.println(salutation + message);
        greetService1.sayMessage("Runoob");
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}


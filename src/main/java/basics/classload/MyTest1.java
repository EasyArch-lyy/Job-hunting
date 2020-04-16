package basics.classload;

/**
 * 主动调用
 *
 * @author lyy
 */

//-XX:+TraceClassLoading用于追踪类的加载信息并打印
//-XX:+<option>          开启option选项
//-XX:-<option>          关闭option选项
//-XX:-<option><value>   option选项值设置为value

public class MyTest1 {

    //启动类--->主动加载
    public static void main(String[] args) {
//        加载子类的静态字段--->子类初始化
//        子类初始化--->导致父类也被主动调用
//        System.out.println(MyChild.str2);
        //加载继承中的静态字段时，只有直接定义了该静态字段的类会被初始化
        System.out.println(MyChild.str);
    }
}

class MyParent1 {

    public static String str = "hello world";

    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild extends MyParent1 {

    public static String str2 = "welcome";

    static {
        System.out.println("Mychild static block");
    }
}
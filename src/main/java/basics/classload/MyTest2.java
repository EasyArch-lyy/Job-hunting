package basics.classload;

//助记符：ldc ---：将-32768>int>32767, 0>float>=6, String 类型的常量池从常量池推送至栈顶
//       fconst_0(~5):将float型1（～5）推送至栈顶
//       bipush-:将单字节-128~127的常量值推送至栈顶
//       sipush :将-32768<int<32767推送至栈顶
//       fipush :将一个短整型常量池（-32768~32767）推送至栈顶
//       iconst_1（～5）:将int型1（～5）推送至栈顶
//       ldc2_w :double 型推送至栈顶

/**
 * 类加载器示例
 *
 * @author lyy
 */
public class MyTest2 {

    public static void main(String[] args) {
        System.out.println(MyParent2.f);
    }
}

class MyParent2 {

    //public static String str="Hello";
    //final表示常量，赋值以后不能再改变
    //常量在编译阶段传入到调用这个常量的方法所在的类的常量池中
    //本质上，调用类并没有直接引用到定义常量的类，不会触发定义常量的类的初始化

    /**
     * str进入MyTest2常量池，可以删除MyParent2.class
     */
    public final static String str = "Hello";
    public static final short a = 7;
    public static final float f=0;

    public static final int m = 128;

    static {
        System.out.println("MyParent2 static block");
    }
}
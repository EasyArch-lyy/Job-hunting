package basics.classload;

import java.util.Random;

/**
 *当有一个接口在初始化时，不要求其父接口完成初始化，
 * 只有真正使用父接口时，（引用接口中所定义的常量时）才会初始化
 */
public class MyTest5 {

    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}

interface MyParent5{

    public static int a=new Random().nextInt();
}

interface MyChild5 extends MyParent5{
    public static int b=5;
}
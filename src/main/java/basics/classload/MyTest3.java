package basics.classload;

import java.util.UUID;

/*
* 当一个常量的值并非编译期间可以确定的，其值不会被放到调用类的常量池
* 程序运行时会主动使用这个常量所在的类，使其初始化
* */
//当一个类初始化时，他继承的接口不会被初始化
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3{

    public static final String str=UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static code");
    }
}

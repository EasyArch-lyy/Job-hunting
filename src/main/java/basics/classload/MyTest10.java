package basics.classload;

class Parent2{
    static int a=3;
    static {
        System.out.println("parent2 static block");
    }
}

class Child2 extends Parent2{
    static int b=4;
    static {
        System.out.println("child2 static block");
    }
}

public class MyTest10 {
    //main方法包含的static{}先执行
    static {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args) {
        Parent2 parent2;//声明引用，不为主动使用
        System.out.println("-----------");
        //主动使用--->初始化
        parent2=new Parent2();
        System.out.println("-----------");
        //调用类的静态变量（主动使用，由于已初始化过,static首次使用）
        System.out.println(Parent2.a);
        System.out.println("-----------");
        System.out.println(Child2.b);
    }
}

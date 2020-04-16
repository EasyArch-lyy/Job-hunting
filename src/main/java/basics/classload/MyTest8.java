package basics.classload;

public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}

class FinalTest{
    //编译期常量，加到使用类的常量池
    public static final int x=3;
//    public static int y=3;
//    public static final int z=new Random().nextInt(3);
    static{
        System.out.println("FinalTest static block");
    }
}
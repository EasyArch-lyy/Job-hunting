package basics.classload;
/**
 * 对数组实例来说，类型是在虚拟机运行期动态生成，表示为[LInterview.jdk.MyParent4
 * 动态生成的类型，父类为java.lang.Object
 * 对数组来说，javaDoc经常将构成数组的元素Component，实际上是将数组降低一个维度的类型
 **/
//anewarray:表示创建引用类型的（如类，接口，数组）数组，并将其引用值压入栈顶
//newarray:表示创建指定原始类型的数组（int,char,float），并将其引用值压入栈顶
public class MyTest4 {

    public static void main(String[] args) {
        //java虚拟加运行时创建的数组类型
        MyParent4[] myParent4=new MyParent4[1];
        //class [LInterview.jdk.MyParent4;
        System.out.println(myParent4.getClass());
        //-->class java.lang.Object
        System.out.println(myParent4.getClass().getSuperclass());

        int[] ints=new int[1];
        //class [I   (Integer)
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());
        char[]chars=new char[1];
        System.out.println(chars.getClass());
        byte[]bytes=new byte[1];
        System.out.println(bytes.getClass());
        short[]shorts=new short[1];
        System.out.println(shorts);
        boolean[]booleans=new boolean[1];
        System.out.println(booleans.getClass());
        //static块只会被触发一次
//        MyParent4 myParent5=new MyParent4();
    }
}

class MyParent4{
    static {
        System.out.println("MyParent static block");
    }
}
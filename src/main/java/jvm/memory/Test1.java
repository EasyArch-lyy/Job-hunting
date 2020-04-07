package jvm.memory;

/**
 * java系统属性
 * @author lyy
 */
public class Test1 {
    public static void main(String[] args) {
        //查看java系统属性
        System.out.println(System.getProperties());
    }
}

//用来查看内存信息
//堆的对象统计
//jmap -histo 7824 > xxx.txt
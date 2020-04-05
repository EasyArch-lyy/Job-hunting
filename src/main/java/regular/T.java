package regular;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T extends Exception{
    String m="xxx";
    double mm=2.0;
    T (){super("ddddd");}
    T(String msg){
        super(msg);
    }
    public void display(){
        System.out.println(m);
    }
    public double method(){
        return Math.sqrt(mm);
    }
}

class ExceptionTest{
    public static void main(String[] args) {

        if (args[0].charAt(0) == 'A') {
            T t = new T();
            System.out.println("kkk" + t.method());
            t.display();
            System.out.println("****in try****");
            try {
                throw t;
            } catch (T e) {
                e.printStackTrace();
            }
        } else if (args[0].charAt(0)=='B') {
            try {
                throw new T("xxxx");
            } catch (T t) {
                t.printStackTrace();
            }
        }else {
            System.out.println(args[0]);
        }
        System.out.println();
    }
}

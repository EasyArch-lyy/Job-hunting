package basics.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyy
 *
 * Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
 * 	at basics.generic.ErrorTest.main(ErrorTest.java:15)
 */
public class ErrorTest {
    public static void main(String[] args) {
        List arr=new ArrayList();
        arr.add("aaaa");
        arr.add(100);
        for(int i=0;i<arr.size();i++){
            String item= (String) arr.get(i);
            System.out.println("item="+item);
        }
    }
}

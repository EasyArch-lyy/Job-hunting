package basics.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyy
 */
public class JustProve {

    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerList.getClass();
        if (classStringArrayList.equals(classIntegerArrayList)) {
            System.out.println("类型相同");
        }
    }
}

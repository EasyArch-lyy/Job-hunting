package regular;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyy
 */
public class Fun {

    public static int maxLenthNoRepeat(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int current = 0;

        //循环字符串，取出每个字符
        for (int index = 0; index < str.length(); index++) {
            //是否包含指定键值
            if (map.containsKey(str.charAt(index))) {
                current = map.get(str.charAt(index)) + 1;
            } else {
                if ((index - current + 1) > maxLength) {
                    maxLength = index - current + 1;
                }
            }
            map.put(str.charAt(index), index);
        }
        System.out.println(maxLength);
        return maxLength;
    }

    public static void main(String[] args) {
        maxLenthNoRepeat("sdafmkkkkasffsdanasdfnregniuafnsas");

    }
}
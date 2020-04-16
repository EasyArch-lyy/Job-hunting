package regular;

/**
 * @author lyy
 */
public class Convert {
    public static void int2Binary(int i) {
        // 整数长度
        int intLen = 8;
        String s = "";
        boolean minus = (i < 0);
        int length = 0;
        //如果是负数，求其反码
        if (minus) {
            i = -i;
        }
        while (i > 0) {
            if (i % 2 != 0) {
                s = "1" + s;
            } else {
                s = "0" + s;
            }
            i /= 2;
            length++;
        }

        if (minus) {
            for (i = 0; i < intLen - length; i++) {
                s = "1" + s;
            }
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        int2Binary(10);
        int2Binary(-128);
    }
}
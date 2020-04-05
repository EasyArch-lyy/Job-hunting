package regular;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lyy
 */
public class Test {
   /**
    * @param content
    * @return 数字的字符串
    * 提取数字正则表达式
    */
    public static String getNumbers(String content) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }
   /**
    * @param content
    * @param index
    * @param off
    * 输入字符串,开始的下标,偏移量
    * @return 返回截取的字符串
    */
    public String getIndexString(String content,int index,int off){
        String str = content;
        String b=str.substring(index,off);
        System.out.println(b);
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int c = Integer.parseInt(getNumbers(a));
        int d = Integer.parseInt(getNumbers(b));
        System.out.println("\"" + (c + d) + "\"");
    }
}
package leetcode;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式
 * @author lyy
 */
public class DateDemo {

   public static void main(String args[]) {
 
      Date dNow = new Date( );
      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
      System.out.println("当前时间为: " + ft.format(dNow));

      String[]a=new String[]{"","",""};

      // 初始化 Date 对象
      Date date = new Date();
      //c的使用
      System.out.printf("全部日期和时间信息：%tc%n",date);
      //f的使用
      System.out.printf("年-月-日格式：%tF%n",date);
      //d的使用
      System.out.printf("月/日/年格式：%tD%n",date);
      //r的使用
      System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
      //t的使用
      System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
      //R的使用
      System.out.printf("HH:MM格式（24时制）：%tR",date);
      // 使用toString()显示日期和时间
      System.out.printf("%1$s %2$tB %2$td, %2$tY",
              "Due date:", date);

   }
}
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题：寻找数组中两数和为给定的数
 *
 * 思路：将数组中的数作为减数,若差的值在数组中存在，找到两数
 * @author lyy
 */
public class TwoNumsSumEquals {
     public static void main(String[] args) {
          int[] arr = new int[]{3, 4, 6, 5, 9, 8};
          int num = 8;
          int[] ret = getIndex(arr, num);
          System.out.println("index of two numbers R:" + ret[0] + " " + ret[1]);
     }
      // 找到这两个数的下标并返回（以长度为2的数组的形式返回）
     private static int[] getIndex(int[] arr, int num) {
          int[] ret = new int[2];
          HashMap<Integer, Integer> hashMap = new HashMap<>();
          int index = 0;
          // 将每个数字和其下标放进map中
          for (Integer curr : arr) {
              hashMap.put(curr, index++);
          }
          // 遍历HashMap并判断
          for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
              int value = entry.getKey();
              int subValue = num - value;
              if(hashMap.containsKey(subValue)) {
                  // 找到啦!
                  ret[0] = entry.getValue();
                  ret[1] = hashMap.get(subValue);
                  break;
              }
          }
          return ret;
     }
}
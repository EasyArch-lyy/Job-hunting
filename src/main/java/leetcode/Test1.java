package leetcode;

import java.util.Scanner;
/**
 * 问题描述
 * 给你一个整数数组 nums，请你将该数组升序排列。
    示例 1：
    输入：nums = [5,2,3,1]
    输出：[1,2,3,5]

    示例 2：
    输入：nums = [5,1,1,2,0,0]
    输出：[0,0,1,1,2,5]
    提示：
    1 <= nums.length <= 50000
    -50000 <= nums[i] <= 50000
  */

class Solution {
   /**
    * 冒泡排序--超出执行时间
    */
    public int[] sortArray1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }

    /**
     * 希尔排序
     */
    public int[] sortArray2(int[] ins) {
        int n = ins.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int j = gap; j < n; j++) {
                int i = j;
                while (i >= gap && ins[i - gap] > ins[i]) {
                    int temp = ins[i - gap] + ins[i];
                    ins[i - gap] = temp - ins[i - gap];
                    ins[i] = temp - ins[i - gap];
                    i -= gap;
                }
            }
            gap = gap / 2;
        }
        return ins;
    }
}

/**
 * @author lyy
 */
public class Test1{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String[]b=a.split(",");
        int[] arr=new int[b.length];
        for(int i=0;i<b.length;i++){
            arr[i]= Integer.parseInt(b[i]);
        }
        Solution solution=new Solution();
        arr=solution.sortArray2(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i!=(arr.length-1)){
                System.out.print(",");
            }
        }
    }
}
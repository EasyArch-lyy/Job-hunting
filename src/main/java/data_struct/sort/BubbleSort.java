package data_struct.sort;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 冒泡排序
 * @author lyy
 */
public class BubbleSort {

    public static void sort(int[] array) {
        int[]r=array;
        int temp = 0;
        // 需要遍历的次数
        for (int i = 0; i < array.length - 1; i++) {
            // 注意 array.length - 1
            for (int j = array.length - 1; j > i; j--) {
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        for(int i=0;i<r.length;i++){
            System.out.print(r[i]);
        }
    }

    public static void main(String[] args) {
        int[]a={1,6,4,3,7,8,9};
        sort(a);
    }
}
package data_struct.sort;

/**
 * 插入排序
 *
 * @author lyy
 */
public class InsertSort {

    public static void sort(int[] arr) {
        int temp = 0;
        int i, j;
        // 第1个数肯定是有序的，从第2个数开始遍历，依次插入有序序列
        for (i = 1; i < arr.length; i++) {
            // 取出第i个数，和前i-1个数比较后，插入合适位置
            temp = arr[i];
           // 因为前i-1个数都是从小到大的有序序列，所以只要当前比较的数(list[j])比temp大，就把这个数后移一位
            for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp; 
        }
    }
}
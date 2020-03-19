package data_struct;

/**
 * @author lyy
 */
public class SelectionSort {
    public static void sort(int[] array) {
        // 需要遍历获得最小值的次数
        // 要注意一点，当要排序 N 个数，已经经过 N-1 次遍历后，已经是有序数列
        // 保存最小数据的索引
        int k = 0;
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            k = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[k]) {
                    // 更新最小数据的索引
                    k = j;
                }
            }
            // 将最小数据交换
            temp = array[k];
            array[k] = array[i];
            array[i] = temp;
        }
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]);
        }
    }

    public static void main(String[] args) {
        int[]a={2,1,7,5,4,3,9};
        sort(a);
    }
}
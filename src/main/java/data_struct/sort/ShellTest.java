package data_struct.sort;

/**
 * 希尔排序
 * @author lyy
 */
public class ShellTest {
    public static void shellSort(int[] array) {

        int gap = array.length;
        while (gap > 0) {
            int temp;
            int j;
            for (int i = 1; i < array.length; i++) {
                temp = array[i];
                for (j = i - gap; j >= 0 && temp < array[j]; j = j - gap) {
                    array[j + gap] = array[j];
                }
                array[j + gap] = temp;
            }
            gap = gap / 2;
        }
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"  ");
        }
    }

    public static void main(String[] args) {
        int[]a={8,5,6,9,3,1,2};
        shellSort(a);
    }
}

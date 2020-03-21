package data_struct;

/**
 * 快速排序
 * @author lyy
 */
public class FastSortTest {

    public static int division(int[] list, int left, int right) {
        // 以最左边的数(left)为基准
        int base = list[left];
        while (left < right) {
            // 从序列右端开始，向左遍历，直到找到小于base的数
            while (left < right && list[right] >= base) {
                right--;
            }
            // 找到了比base小的元素，将这个元素放到最左边的位置
            list[left] = list[right];
            // 从序列左端开始，向右遍历，直到找到大于base的数
            while (left < right && list[left] <= base) {
                left++;
            }
            // 找到了比base大的元素，将这个元素放到最右边的位置
            list[right] = list[left];
        }

        // 最后将base放到left位置。此时，left位置的左侧数值应该都比left小；
        // 而left位置的右侧数值应该都比left大。
        list[left] = base;
        return left;
    }

    public static void quickSort(int[] list, int left, int right) {
        // 左下标一定小于右下标，否则就越界了
        if (left < right) {
            // 对数组进行分割，取出下次分割的基准标号
            int base = division(list, left, right);

            // 对“基准标号“左侧的一组数值进行递归的切割，以至于将这些数值完整的排序
            quickSort(list, left, base - 1);

            // 对“基准标号“右侧的一组数值进行递归的切割，以至于将这些数值完整的排序
            quickSort(list, base + 1, right);
        }
    }

    public static void main(String[] args) {

    }
}
//排序法	平均时间	    最差情形	    稳定度	额外空间	    备注
//冒泡	O(n2)	    O(n2)	    稳定   	  O(1)	   n小时较好
//选择	O(n2)	    O(n2)	    不稳定	  O(1)	   n小时较好
//插入	O(n2)	    O(n2)	    稳定	      O(1)	   大部分已排序时较好
//基数	O(logRB)	O(logRB)	稳定	      O(n)     //B是真数(0-9)，R是基数(个十百)
//Shell	O(nlogn)	O(ns)1<s<2	不稳定	  O(1)	    s是所选分组
//快速	O(nlogn)	O(n2)	    不稳定	  O(nlogn)	n大时较好
//归并	O(nlogn)	O(nlogn)	稳定	      O(1)	    n大时较好
//堆	O(nlogn)	O(nlogn)	不稳定	  O(1)	    n大时较好
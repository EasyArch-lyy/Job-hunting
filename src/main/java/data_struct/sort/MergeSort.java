package data_struct.sort;

/**
 * 归并排序
 * @author lyy
 */
public class MergeSort {

    public static void mergeSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        //合并
        mergeArray(a, left, mid, right);
    }

    // 两个排好序的子序列合并为一个子序列
    public static void mergeArray(int[] a, int left, int mid, int right) {
        //辅助数组
        int[] temp = new int[a.length];
        //p1、p2是检测指针，k是存放指针
        int p1 = left, p2 = mid + 1, k = left;
        while (p1 <= mid && p2 <= right) {
            if (a[p1] < a[p2]) {
                temp[k++] = a[p1++];
            } else {
                temp[k++] = a[p2++];
            }
        }

        //如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p1 <= mid) {
            temp[k++] = a[p1++];
        }
        while (p2 <= right) {
            temp[k++] = a[p2++];
        }

        for (int i = left; i <= right; i++) {
            a[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 3, 7, 4, 8, 10};
        System.out.println("原数组为：");
        mergeSort(a, 0, a.length - 1);
        System.out.println("排序之后的数组为");
    }
}
package leetcode.sort;

import java.util.Arrays;

/**
 * @author lyy
 */
public class Shell {

	/**
	 * 排序方法
	 * @param arr 待排序的数组
	 * @return toString 方便输出
	 */
	public static String shellSort(int[] arr) {

		//当前正在比较的数字（下方简称：“当前”）
		int current;
		//初始增量（此处为：希尔增量）
		int gap = arr.length / 2;
		//gap=1的时候，数组已经有序
		while(gap > 0) {
			for (int i = gap; i < arr.length; i++) {
				current = arr[i];
				//与“当前”同组的前一个数字
				int preIndex = i - gap;
				//找到同组内比“当前”小的数字
				while (preIndex >= 0 && current < arr[preIndex]) {
					//在向后移动同组内已排好序的，大于“当前”的数字
					arr[preIndex + gap] = arr[preIndex];
					preIndex -= gap;
				}
				//插入“当前”到相应的位置
				arr[preIndex + gap] = current;
			}
			//缩小增量
			gap /= 2;
		}
		return Arrays.toString(arr);
	}

	public static void main(String[] args) {

		int[] arr = {111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31};
		System.out.println("排序后的数组："+ shellSort(arr));
	}
}

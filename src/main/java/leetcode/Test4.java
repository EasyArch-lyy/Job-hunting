package leetcode;

//    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//        示例:
//        给定 nums = [2, 7, 11, 15], target = 9
//        因为 nums[0] + nums[1] = 2 + 7 = 9
//        所以返回 [0, 1]

class Solution4 {
    public int[] twoSum(int[] nums, int target) {
        int[]a=new int[2];
        for(int i=0;i<nums.length;i++){
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    if (i<j){
                        a[0]=i;
                        a[1]=j;
                    }else {
                        a[0]=j;
                        a[1]=i;
                    }
                }
            }
        }
        return a;
    }
}

/**
 * @author lyy
 */
public class Test4 {
    public static void main(String[] args) {
        Solution4 solution=new Solution4();
        int[]a={2, 1, 16, 15};
        int target=17;
        int[]b=solution.twoSum(a,target);
        System.out.print("["+b[0]+","+b[1]+"]");
    }
}



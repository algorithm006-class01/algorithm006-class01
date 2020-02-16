package leetcode;

public class LeetCode_283_535 {


    /**
     * 题目：
     * https://leetcode-cn.com/problems/move-zeroes/
     */

    public static void moveZeroes3(int[] nums) {
        int[] A = new int[nums.length];
        int maxIndex = nums.length - 1;
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                A[maxIndex] = nums[i];
                maxIndex--;
            }else {
                A[minIndex] = nums[i];
                minIndex++;
            }
        }
    }



    public static void moveZeroes2(int[] nums) {
        int snowBallSize  = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                snowBallSize++;
            }else if (snowBallSize > 0){
                int t = nums[i];
                nums[i] = 0;
                nums[i - snowBallSize] = t;
            }
        }
    }

    public static void moveZeroes1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j] = nums[i];
                if (i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {0,1,0,3,12};
        moveZeroes3(A);
    }

}

/**
 * 1.loop,count，zeros
 * 2.开新数组，loop  i 指向新数组的头，j指向新数组的尾(内存空间比较多)
 * 3.index
 */

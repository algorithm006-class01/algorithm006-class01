package G20200343030391;

import java.util.Arrays;

public class LeetCode_189_391 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 环状替换：从开始位置连续替换，发生碰撞则开启下一轮替换
     * 时间复杂度：O(n)
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int currentVal = nums[start];
            do {
                int newIndex = (current + k) % (nums.length);
                int temp = nums[newIndex];
                nums[newIndex] = currentVal;
                currentVal = temp;
                current = newIndex;
                count++;
            } while (start != current);
        }
    }
}

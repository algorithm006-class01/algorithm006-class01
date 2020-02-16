package array;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 1 || k <= 0) {
            return;
        }

        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int pre = nums[start];
            int current = start;
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums, k);
    }

}

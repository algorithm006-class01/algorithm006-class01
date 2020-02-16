package array;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes01 {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        MoveZeroes01 moveZeroes = new MoveZeroes01();
        moveZeroes.moveZeroes(nums);
        System.out.println(nums);
    }

}

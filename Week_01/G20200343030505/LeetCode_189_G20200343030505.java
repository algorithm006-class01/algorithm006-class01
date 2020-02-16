/**
 * 
 */

/**
 * @author huangwen05
 *
 * @date:   2020年2月16日 下午8:47:10 
 */
public class LeetCode_189_G20200343030505 {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int lenth = nums.length;
        int r = k%lenth;
        if(r == 0) return;
        int x = lenth - r;
        rotate(nums,0, x - 1);
        rotate(nums, x, lenth - 1);
        rotate(nums, 0, lenth - 1);
    }

    public void rotate(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            --j;
            ++i;
        }
    }
}
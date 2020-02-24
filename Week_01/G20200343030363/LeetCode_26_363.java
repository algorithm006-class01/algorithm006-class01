package cn.geet.week1;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月14日 16:09:00
 */
public class LeetCode_26_363 {

    /**
     * Remove duplicates int. 不考虑新数组长度后面的数字
     *
     * @param nums
     *            the nums
     * @return the int
     */
    public int removeDuplicates(int[] nums) {

        if (nums == null || (null != nums && nums.length == 0)) {
            return 0;
        }

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        LeetCode_26_363 temp = new LeetCode_26_363();
        int result = temp.removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(result);
    }
}

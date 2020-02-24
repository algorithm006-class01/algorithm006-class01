package leetcode.week01;

/**
 * @author Abner.S
 * @date 2020/2/16 16:17
 * @description No. 189 rotate-array
 * 旋转数组
 */
public class LeetCode_189_429 {

    /**
     * 思路1：每次将数组依次移动一位，循环 k 次
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int temp;
        int previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length -1];

            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 思路2：反转，移动 k 次， k % length 对应的元素即成为首个元素, k = k % length
     * 有可能存在 k > length 的情况
     * 1、将所有元素反转
     * 2、反转前 k 个元素，这 k 个元素恰好是从原数组末端要移动到数组前端的元素
     * 3、将 n - k 个元素反转，即原来的顺序
     * 4、得到结果
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        // 得到旋转的具体位置
        k %= nums.length;
        // 反转所有元素
        reverse(nums, 0, nums.length);
        // 反转前 k 个元素
        reverse(nums, 0, k - 1);
        // 反转剩下元素
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 反转数组元素
     * @param nums 传入数组
     * @param start 反转起始位置
     * @param end 反转结束位置
     */
    private void reverse(int[] nums, int start, int end) {
        // 从两侧向中间夹逼替换元素
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

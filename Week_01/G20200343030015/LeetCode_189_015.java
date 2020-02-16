package G20200343030015.week_01;

/**
 * Created by majiancheng on 2020/2/16.
 */
public class LeetCode_189_015 {

    /**
     * 第一种方法, 暴力求解
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }

    /**
     * 第二种方法, 翻转数组
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse2(nums, 0, nums.length - 1);
        reverse2(nums, 0, k - 1);
        reverse2(nums, k, nums.length - 1);
    }

    /**
     * 第三种方法, 环状替换
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int tmp = nums[next];
                nums[next] = prev;

                current = next;
                prev = tmp;
                count++;
            } while (start != current);
        }
    }

    public void reverse2(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        /*new LeetCode_189_015().rotate1(nums, 3);*/
        /*new LeetCode_189_015().rotate2(nums, 3);*/
        new LeetCode_189_015().rotate3(nums, 3);
        for (int i : nums) {
            System.out.print(i + ", ");
        }
    }
}

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

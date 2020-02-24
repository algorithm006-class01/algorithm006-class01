package G20200343030015.week_01;

/**
 * Created by majiancheng on 2020/2/16.
 */
public class LeetCode_283_015 {

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;

                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        new LeetCode_283_015().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

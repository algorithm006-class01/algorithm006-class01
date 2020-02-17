/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // 记录数组中当前非零元素的位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            // 将当前非零元素填充到 j 位置，如果需要，则在当前位置填充 0
            nums[j] = nums[i];
            if (i != j) {
                // 说明在当前非零元素之前出现了 0 ，而当前非零元素被填充到了 j 位置，此位置应补充 0 (相当于将当前非零元素与0进行互换)
                nums[i] = 0;
            }
            j++;
        }
    }

}
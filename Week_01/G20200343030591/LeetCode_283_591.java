
class Solution {


    /**
     * 题目名称：移动0
     * 思路解析：
     * 1、定义一个j指针，用于指向下一个不为0的位置
     * 2、定义一个i指针，遍历数组查找不为0的数
     * 3、i和j一起向前走，j遇到为0的数就停下来，i则继续向前走
     * 4、i只要不为0，就与j交换位置，交换完成后，j向前走一步
     * 5、重复3~4，直到遍历完数组
     *
     * 易错点，老是想让i从1开始，他俩从同一个位置开始走
     * @param nums
     * @return
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len == 0) return;

        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i]!=0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}




public class LeetCode_283_089 {
    // 两次遍历解法
    public void solution1(int[] nums) {
        int visited = 0;
        // 移动非零元素
        for (int i =0; i < nums.length; ++i) {
            if(nums[i] != 0) {
                nums[visited++] = nums[i];
            }
        }
        // 将剩余空间填充为0
        for (int i=visited; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }

    // 一次遍历
    public void solution2(int[] nums) {
        int pivot = 0;
        for (int i=0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot++] = temp;
            }
        }
    }

}

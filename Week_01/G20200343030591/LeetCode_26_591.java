
class Solution {


    /**
     * 思路解析：
     * 1.创建两个指针 快指针和慢指针
     * 2、当两个指针值 相等，慢指针不动，快指针继续向前移动
     * 3、两个指针值 不相等，将快指针所在位置的值赋给 慢指针+1的位置，并且慢指针向前移动一位
     * 4、重复2~3 知道fast等于数组长度
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        int slow = 0;
        for (int fast=1; fast < len; fast++) {
            if (nums[fast]!=nums[slow]) {
                nums[++slow] = nums[fast];
            }
        }
        return ++slow;
    }

}




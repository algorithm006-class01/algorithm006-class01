//题目链接: https://leetcode-cn.com/problems/rotate-array/

class Solution {
    /** 
     *  方法1: 暴力求解
     * 时间复杂度O(n*k): 每个元素都被移动1步O(n),k次（O(k);
     * 空间复杂度O(1): 使用常数个额外的空间
     */
    public void rotate1(int[] nums, int k) {
        int temp, previous;
        //旋转k次
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            //每次数组旋转一个元素
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
    /**
     * 方法2: 环状替换
     * 时间复杂度O(n): 只遍历每个元素一次
     * 空间复杂度O(1): 使用常数个额外空间
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    /**
     * 方法3: 反转
     * 时间复杂度O(n): n个元素反转了总共3次
     * 空间复杂度O(1): 使用常数个额外空间
     */
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        //1.反转整个数组数字
        reverse(nums, 0, nums.length - 1);
        //2.反转前k个数字
        reverse(nums, 0, k - 1);
        //3.反转后n-k个数字
        reverse(nums, k, nums.length - 1);
    }
        //反转函数
        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

}
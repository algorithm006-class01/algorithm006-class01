/**
 * 
 * homework
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 
 * 题目要点: 1. 有序的数组 2. 双指针法解决相同元素 3. 返回的是新数组的长度
 * 特别注意: 遍历的时候一定要根据返回的数组的新的长度进行遍历,否则会出现 eg. [1,1,2] ==> [1,2,2]
 * time complexity O(n) 
 * space complexity O(1)
 * 
 * 
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
package FistWork;
//  1 遍历数组，找到重复的元素--java中有现成的函数吧
//  2 删除重复元素，返回新数组
//  3 思路尝试不通，估使用（copy）的是leetcode上的解法
public class Solution01 {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 1) {
			return nums.length;
		}
		int i = 0, j = 1;
		while (j < nums.length) {
			if (nums[i] == nums[j]) {
				j++;
			} else {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
}

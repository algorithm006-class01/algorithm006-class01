package week08;
import java.util.Arrays;

/*
 * 300. Longest Increasing Subsequence
 * 最长上升子序列
 * 
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

 */
public class LeetCode_300_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//状态定义dp[i], 表示当包含nums[i]的这个位置最长上升子序列的长度
	//状态方程  dp[i] = max(所有dp[j]) {0<=j<i且num[j]<num[i]的所有值}
	class Solution {
	    public int lengthOfLIS(int[] nums) {
	    	if( nums.length == 0 )
	    		return 0;
	    	int[] dp = new int[nums.length];
	    	Arrays.fill(dp, 1);
	    	int max = 1;
	    	for(int i = 1; i < dp.length; i++) {
	    		for( int j = 0; j < i; j++ ) {
	    			if( nums[j] < nums[i] )
	    				dp[i] = Math.max(dp[i], dp[j]+1);
	    		}
	    		max = Math.max(max, dp[i]);
	    	}
	    	return max;
	    }
	}
}

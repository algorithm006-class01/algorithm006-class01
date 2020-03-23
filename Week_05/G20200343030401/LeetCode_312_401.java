//题目链接：https://leetcode-cn.com/problems/burst-balloons/
class Solution{
    public int maxCoins(int[] nums){
        int dp[][] = new int[nums.length][nums.length];
        if(nums.length == 0){  
            return 0;
        }
        for(int i = 0; i<nums.length; i++){
            for(int j = 0;j<nums.length-i;j++){
                fill(dp,nums,j,j+i);
            }
        }
        return dp[0][nums.length-1];
    }
    void fill(int[][] dp,int nums[],int start,int end){
        int max = 0;
        for(int i=start; i<=end;i++){
            max = Math.max(max,(start-1<0 ? 1 : nums[start-1])*nums[i]*(end+1>nums.length-1 ? 1 : nums[end+1]) + (start>i-1 ? 0 : dp[start][i-1]) + (end < i+1 ? 0 : dp[i+1][end]));
        }
        dp[start][end] = max;
    }
}


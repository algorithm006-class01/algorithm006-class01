/**
 *
 *  最大自序和
 *
 */
class Solution {
    //贪心
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < len; i++) {
            currSum = Math.max(nums[i],currSum + nums[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }

    //动态规划
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int maxSum = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i],maxSum);
        }
        return maxSum;
    }
}
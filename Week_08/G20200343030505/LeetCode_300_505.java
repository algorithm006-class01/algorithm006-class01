//首先搞清楚 子序列是否连续
// dp[i]以i结尾的最长上升长度  每次求dp[i]时  依次遍历0-i-1 判断i元素是否比他们大 如果大的话 计算长度 然后取最长的
//
//
//思路：一般我们求得是长度，可能面试会要求输出序列 需要考虑下怎么写
class LeetCode_387_505 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        dp[0] = 1;
        for (int i=1;i<nums.length;++i) {
            int temp = 0;
            for (int j=0;j<i;++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);                    
                }
            } 

            max = Math.max(dp[i], max);
        }

        return max;
    }
}




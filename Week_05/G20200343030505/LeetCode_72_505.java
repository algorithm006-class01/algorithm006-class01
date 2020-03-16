/**
 * 使用栈
 * @author huangwen05
 *
 * @date:   2020年2月23日 下午7:53:59
 */
class LeetCode_72_505 {
         int n1 = word1.length() + 1;
        int n2 = word2.length() + 1;

        //状态函数：需要保留空串，所以长度加1；
        //长度从0开始
        int[][] dp = new int[n1][n2];

        //dp[0][i]:表示word1为空串 word1转为word2表示插入操作
        for (int i=1;i<n2;++i) {
            dp[0][i] = dp[0][i-1] + 1;
        }
        //dp[i][0]:表示word2为空串 word1转为word2表示删除操作
        for (int i=1;i<n1;++i) {
            dp[i][0] = dp[i-1][0] + 1;
        }

        for (int i=1;i<n1;++i) {
            for (int j=1;j<n2;++j) {
                //如果当前i和j元素相同，状态转移=i-1,j-1
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //否则由以下三步最小的一个转移
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])  + 1;
                }
            }
        }
        
        return dp[n1 - 1][n2 - 1];

    }
}
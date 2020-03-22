/**
 * 使用栈
 * @author huangwen05
 *
 * @date:   2020年2月23日 下午7:53:59
 */
class LeetCode_221_505 {
    if (matrix == null) {
            return 0;
        }
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int colum = matrix[0].length;
        //增加一维，方便计算
        //dp(i,j)表示右下角i,j为止的最大正方形的边长
        int[][] dp = new int[row + 1][colum + 1];
        int maxlenth = 0;
        for (int i=1;i<=row;++i) {
            for (int j=1;j<=colum;++j) {
                if (matrix[i-1][j-1] == '1') {
                    //每次更新边长，取min 保证是正方向有效的
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j]) + 1;
                    if (dp[i][j] > maxlenth) {
                        maxlenth = dp[i][j];
                    }
                }
                
            }

        }

        return maxlenth * maxlenth;

    }
}
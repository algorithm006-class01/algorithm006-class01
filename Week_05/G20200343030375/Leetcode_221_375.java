package G20200343030375;

public class Leetcode_221_375 {
    public int maximalSquare(char[][] matrix) {
        int rs = matrix.length;
        if (rs == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int[][] dp = new int[rs + 1][cols + 1];
        int ms = 0;
        for (int i = 1; i <= rs; i++) {
            for (int j = 1; j <= cols; j++) {
                //因为多申请了一行一列，所以这里下标要减 1
                if (matrix[i - 1][j - 1] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    ms = Math.max(dp[i][j], ms);
                }
            }
        }
        return ms * ms;
    }
    public static void main(String[] args){
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        
        Leetcode_221_375 ltc = new Leetcode_221_375();
        
        System.out.println(ltc.maximalSquare(matrix));
    }
}

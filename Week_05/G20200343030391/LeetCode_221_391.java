package G20200343030391;

public class LeetCode_221_391 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        int maximalSquare = new LeetCode_221_391().maximalSquare_2(matrix);
        System.out.println(maximalSquare);
    }

    /**
     * 暴力
     * @param matrix
     * @return
     */
    public int maximalSquare_1(char[][] matrix) {
        int row = matrix.length;
        int clo = matrix[0].length;
        int maxSquare = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                if (matrix[i][j] == '1') {
                    int square = 1;
                    boolean flag = true;
                    while (square + i < row & square + j < clo & flag) {
                        for (int k = j; k <= square + j; k++) {
                            if (matrix[i + square][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= square + i; k++) {
                            if (matrix[k][j + square] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            square++;
                    }
                    if (maxSquare < square) {
                        maxSquare = square;
                    }
                }
            }
        }
        return maxSquare * maxSquare;
    }

    /**
     * 动态规划
     * @param matrix
     * @return
     */
    public int maximalSquare_2(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }


}

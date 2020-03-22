
/**
 * 解题思路: 动态规划方式查找边长，根据正方形特性，假想一个以当前点作为右下角的正方形，每次计算当前范围内边长
 * 时间复杂度: O(mn)
 * 空间复杂度: O(mn)
 * 执行用时: 9 ms, 在所有 Java 提交中击败了24.33%的用户
 * 内存消耗: 43.6 MB, 在所有 Java 提交中击败了8.69%的用户
 */
public class Solution {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        // 边界条件
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // 记录二维数组的行列
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        // 记录中间状态，行列各多增加一，作为初始状态
        int[][] dp = new int[rowCount + 1][colCount + 1];
        // 记录最大边长
        int maxSquareLength = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if ('1' == matrix[i][j]) {
                    // 因为中间状态扩展了行列，故计算matrix中的行列中间状态对应的dp时，需要偏移+1
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i][j]), dp[i + 1][j]) + 1;
                    maxSquareLength = Math.max(maxSquareLength, dp[i + 1][j + 1]);
                }
            }
        }
        return maxSquareLength * maxSquareLength;
    }
}

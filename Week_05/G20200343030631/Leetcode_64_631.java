/**
 * 解题思路: 自底向上动态规划，碰到边界直接取上方或者左侧元素，未达到边界，取左侧、上方元素中的最小值
 * 时间复杂度: O(mn)
 * 空间复杂度: O(1)
 * 执行用时: 5 ms, 在所有 Java 提交中击败了11.00%的用户
 * 内存消耗: 42.4 MB, 在所有 Java 提交中击败了23.13%的用户
 */
public class Solution {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        // 边界条件
        if (null == grid || grid.length == 0){
            return 0;
        }
        // 二维数组的行列数
        int rowCount = grid.length;
        int colCount = grid[0].length;
        // 自底向上逐步计算
        for (int i = rowCount - 1; i >= 0; i--) {
            for (int j = colCount - 1; j >= 0; j--) {
                if (j == colCount - 1 && i != rowCount - 1){ // 达到列边界，不许判断最小值，直接取值
                    grid[i][j] = grid[i][j] + grid[i+1][j];
                }else if (j != colCount - 1 && i == rowCount - 1){ // 达到行边界，直接取值
                    grid[i][j] = grid[i][j] + grid[i][j+1];
                }else if (j != colCount - 1 && i != rowCount - 1){ // 行列都未达到边界，取左侧、上方元素中的最小值
                    grid[i][j] = grid[i][j] + Math.min(grid[i+1][j], grid[i][j+1]);
                }
            }
        }
        return grid[0][0];
    }
}

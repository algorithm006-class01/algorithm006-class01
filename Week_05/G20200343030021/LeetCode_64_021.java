package dynamicprogramming;

/**
 * #### [64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)
 * 动态规划
 * 1.重复性 f(i,j) = min（f（i-1,j），f(i,j-1)） + f(i,j)
 * 2.定义状态函数 f（i,j） 表示当前位置 和为最小
 * 3.DP方程：F[i,j] = min(F[i-1,j],F[i,j-1])+F[i,j]
 */
public class MinimumPathSum {
    //  注意点：最左侧和最上侧
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
//                左侧所有的最小和
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
//                右侧所有的最小和
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    //使用一维数组空间
    public int minPathSum2(int[][] grid) {
        int[] ints = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) ints[j] = ints[j] + grid[i][j];
                else if (i == 0) ints[j] = ints[j - 1] + grid[i][j];
                else ints[j] = Math.min(ints[j], ints[j - 1]) + grid[i][j];
            }
        }
        return ints[grid[0].length - 1];
    }


    //  暴力递归
    public int minPathSum3(int[][] grid) {
        return calculate(grid, 0, 0);
    }

    private int calculate(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) {
            return Integer.MAX_VALUE;
        }
//        递归终止条件
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
//        当期层逻辑，下探下一层
        return Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1)) + grid[i][j];
    }
}

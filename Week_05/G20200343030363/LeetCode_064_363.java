package cn.geek.week5;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月15日 13:52:00
 */
public class LeetCode_064_363 {

    /**
     * Min path sum int.
     *
     * @param grid
     *            the grid
     * @return the int
     */
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}

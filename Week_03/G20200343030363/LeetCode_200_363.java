package cn.geek.week3;

/**
 *
 * 岛屿数量
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月29日 16:26:00
 */
public class LeetCode_200_363 {

    /**
     * Num islands int.
     *
     * @param grid
     *            the grid
     * @return the int
     */
    public int numIslands(char[][] grid) {

        if (null == grid || grid.length == 0) {
            return 0;
        }

        int height = grid.length;
        int width = grid[0].length;
        int isLand = 0;
        for (int h = 0; h < width; h++) {
            for (int w = 0; w < height; w++) {
                if (grid[h][w] == '1') {
                    ++isLand;
                    dfs(grid, h, w);
                }
            }
        }
        return isLand;
    }

    /**
     * Dfs.
     *
     * @param grid
     *            the grid
     * @param h
     *            the h
     * @param w
     *            the w
     */
    public void dfs(char[][] grid, int h, int w) {
        int height = grid.length;
        int width = grid[0].length;
        if (h < 0 || w < 0 || h >= height || w >= width || grid[h][w] == '0') {
            return;
        }
        grid[h][w] = '0';
        dfs(grid, h - 1, w);
        dfs(grid, h + 1, w);
        dfs(grid, h, w - 1);
        dfs(grid, h, w + 1);
    }
}

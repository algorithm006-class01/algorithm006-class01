package G20200343030015.week_06;

/**
 * Created by majiancheng on 2020/3/22.
 */

/**
 * 200. 岛屿数量
 * <p>
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_200_015 {

    //使用深度优先遍历
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int rl = grid.length;
        int cl = grid[0].length;
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    //深度优先遍历
    public void dfs(char[][] grid, int i, int j) {
        int rl = grid.length;
        int cl = grid[0].length;
        if (i < 0 || j < 0 || i >= rl || j >= cl || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

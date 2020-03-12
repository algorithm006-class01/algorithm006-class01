package G20200343030391;

public class LeetCode_200_391 {

    public static void main(String[] args) {
        LeetCode_200_391 solution = new LeetCode_200_391();
        char[][] grid1 = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}};
        int numIslands1 = solution.numIslands_DFS(grid1);
        System.out.println(numIslands1);

//        char[][] grid2 = {
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}};
//        int numIslands2 = solution.numIslands_DFS(grid2);
//        System.out.println(numIslands2);
    }

    /**
     * 深度优先
     *
     * @param grid
     * @return
     */
    public int numIslands_DFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int island = 0;
        boolean[][] visited = new boolean[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (!visited[r][c] && grid[r][c] == '1') {
                    island++;
                    dfs(grid, visited, r, c);
                }
            }
        }
        return island;
    }

    /**
     * 查找四个方向关联的陆地
     *
     * @param grid
     * @param visited
     * @param r
     * @param c
     */
    private void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        //标记已访问
        visited[r][c] = true;
        //上
        if (r - 1 >= 0 && grid[r - 1][c] == '1' && !visited[r - 1][c]) {
            dfs(grid, visited, r - 1, c);
        }
        //下
        if (r + 1 < grid.length && grid[r + 1][c] == '1' && !visited[r + 1][c]) {
            dfs(grid, visited, r + 1, c);
        }
        //左
        if (c - 1 >= 0 && grid[r][c - 1] == '1' && !visited[r][c - 1]) {
            dfs(grid, visited, r, c - 1);
        }
        //右
        if (c + 1 < grid[0].length && grid[r][c + 1] == '1' && !visited[r][c + 1]) {
            dfs(grid, visited, r, c + 1);
        }
    }

    /**
     * 广度优先
     *
     * @param grid
     * @return
     */
    public int numIslands_BFS(char[][] grid) {
        return 0;
    }
}

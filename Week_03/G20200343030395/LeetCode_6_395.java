package Week_03.G20200343030395;

public class LeetCode_6_395 {

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return  0;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        int nums = 0;
        //遍历整个图
        for (int r = 0; r < nr; ++r) {
            for (int c = 0;c < nc; ++c) {
                //如果是1，从这里开始深度遍历，并设置为一个岛屿
                if(grid[r][c] == '1') {
                    nums ++;
                    dfs(grid, r, c);
                }
            }
        }

        return nums;
    }

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        //边界条件和已遍历判断
        if(r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        //当前节点设置为已遍历
        grid[r][c] = '0';

        //四个方向扩深度遍历
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }
}

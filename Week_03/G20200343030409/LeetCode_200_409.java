/*
    use flood fill, use dfs to traverse all island, and mark vistied

    time complexity: O(n*m), space complexity: O(1), n is grid's height, m is grid's width

*/
class Solution {
    private int n; //grid's height
    private int m; //grid's width
    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) return 0;

        m = grid[0].length;

        int count = 0;

        // loop grid[][]
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') { //if touch the land, do dfs traverser
                    dfs(grid, i, j);
                    count++; //find island, count++
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        // terminator
        // out of bound or it's water
        if (i < 0 || j < 0 || i >= n || j >=m || grid[i][j] == '0') return;

        //drill down
        // an islan to be sinked, visited, island becomes water
        grid[i][j] = '0';

        // traverse all surrouding area
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);

    }
}
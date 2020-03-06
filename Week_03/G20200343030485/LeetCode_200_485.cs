public class Solution {
    public int NumIslands(char[][] grid) {
        int xsize = grid.Length;
        if (xsize == 0) {
            return 0;
        }

        int ysize = grid[0].Length;
        if (ysize == 0) {
            return 0;
        }
        
        int count = 0;

        for (int x = 0; x < xsize; x++) {
            for (int y = 0; y < ysize; y++) {
                if (grid[x][y] == '1') {
                    count++;
                    Dfs(grid, x, y);
                }
            }
        }

        return count;
    }

    public void Dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.Length || y < 0 || y >= grid[0].Length) {
            return;
        }

        if (grid[x][y] != '1') {
            return;
        }

        grid[x][y] = '2';

        Dfs(grid, x - 1, y);
        Dfs(grid, x + 1, y);
        Dfs(grid, x, y - 1);
        Dfs(grid, x, y + 1);
    }
}
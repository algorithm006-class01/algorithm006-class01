class LeetCode_200_505 {
   private int count = 0;
    private static final int[][] directs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    private boolean[][] marked;
    private int row;
    private int column;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        row = grid.length;
        column = grid[0].length;
        marked = new boolean[row][column];
        for (int i=0;i<row;++i) {
            for (int j=0;j<column;++j) {
                if (grid[i][j] == '1' && !marked[i][j]) {
                    ++count;
                    dfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        marked[i][j] = true;
        for (int k=0;k<directs.length;++k) {
            int dx = i + directs[k][0];
            int dy = j + directs[k][1];
            if (isInArea(dx, dy) && !marked[dx][dy] && grid[dx][dy] == '1') {
                dfs (grid, dx, dy);
            }
        }

    }

    public boolean isInArea(int i, int j) {
        return (i >= 0 && j >= 0 && i <= row - 1 && j <= column - 1) ?true:false;
    }



}
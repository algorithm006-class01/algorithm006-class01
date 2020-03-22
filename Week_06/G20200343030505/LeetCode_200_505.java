class LeetCode_200_505 {

    private int count;
    private boolean[][] marked;
    private int[] dx;
    private int[] dy;
    private int len;
    private int colum;

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        len = grid.length;
        if (len == 0) {
            return 0;
        }
        colum = grid[0].length;
        //标记已经访问过的节点
        marked = new boolean[len][colum];
        //定义方向 如dx[0]和dy[0]表示朝x轴右边走 其他以此类推
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, -1, 0, 1};

        for (int i=0;i<len;++i) {
            for (int j=0;j<colum;++j) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    ++count;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
        
    }

    //从i，j节点开始搜索
    public void dfs(char[][] grid, int i, int j) {
        //从四个方向搜索
        for (int k=0;k<dx.length;++k) {
            int ti = i + dx[k];
            int tj = j + dy[k];
            if (isArea(ti, tj) && !marked[ti][tj] && grid[ti][tj] == '1') {
                marked[ti][tj] = true;
                dfs(grid, ti, tj);
            }
        }      

    }

    public boolean isArea(int i, int j) {
        return i>=0 && i<len && j>=0 && j<colum?true:false;
    }
}
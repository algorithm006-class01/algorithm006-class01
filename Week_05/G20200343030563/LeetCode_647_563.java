class Solution {
     int n;
    int m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    PutO(i, j, grid);
                    //调用递归
                }

            }

            return count;
    }

    private void PutO(int i, int j, char[][] grid) {
        //终止条件 递归的递可以停了，开始归了
        if (i >= n || j >= m || i < 0 || j < 0  || grid[i][j] == '0') return;;

        //当前层处理
        grid[i][j] = '0';

        //进入下一层
        PutO(i+1, j, grid);
        PutO(i-1, j, grid);
        PutO(i, j+1, grid);
        PutO(i, j-1, grid);

        //递归回来，清除对上一层的影响
    }
}
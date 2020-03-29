class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        dfs(n, 0, 0, 0, 0);
        return count;
    }

    private void dfs(int n, int row, int column, int pie, int na) {
        if (row >= n) {
            count++;
            return;
        }
        //得到当前所有到可用位置如(n=4), 1110 , 1表示可用位置
        int available = (~(column | pie | na)) & ((1 << n) - 1);

        while(available != 0) {
            //获取最低位的1， 对于1110， 即10
            int p = available & -available;
            //最低位的1置为0，表示该位置被皇后占用了
            available = available & (available - 1);
            // column | p 表示第p列占用了
            // (pie | p) << 1 表示p位置对应的撇被占用，为何要左移，因为pie位置是在p左边的
            // (na | p) >> 1 表示p位置对应的捺被占用， 右移是因为na位置在p右边
            dfs(n, row + 1, column | p, (pie | p) << 1, (na | p) >> 1);
        }
    }

  
}
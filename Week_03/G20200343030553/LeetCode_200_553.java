class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i< grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int curr = grid[i][j];
                if(curr == '1'){
                    count++;
                    xiaochu(i, j, grid);
                }
            }
        }
        return count;
    }

    public void xiaochu(int i, int j, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        if(i<0 || j<0 || i>(n-1) || j>(m-1) || grid[i][j]=='0')
            return;
        grid[i][j] = '0';
        xiaochu(i-1,j,grid);
        xiaochu(i+1,j,grid);
        xiaochu(i,j-1,grid);
        xiaochu(i,j+1,grid);
    }
}
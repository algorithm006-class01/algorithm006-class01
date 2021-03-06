

class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    char[][] g;
    public int numIslands(char[][] grid) {
        int islands = 0;
        g = grid;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                islands += sink(i,j);
            }
        }
        return islands;
    }

    public int sink(int i, int j){
        if(g[i][j] == '0'){
            return 0;
        }
        g[i][j] = '0';

        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >= 0 && x < g.length && y >=0 && y < g[i].length){
                sink(x,y);
            }
        }
        return 1;
    }
}
class Solution {

    int[] dx = {-1,-1,0,1,1,1,0,-1};
    int[] dy = {0,1,1,1,0,-1,-1,-1};

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board,click[0],click[1]);
        return board;
    }

    public void dfs(char[][] board, int x, int y){
        int r = board.length;
        int c = board[0].length;
        if(x >= 0 && x < r && y >=0 && y < c){
            if(board[x][y] == 'E'){
                board[x][y] = 'B';
                int count = judge(board,x,y);
                //周围没有地雷
                if(count == 0){
                    for (int i = 0; i < 8; i++) {
                        dfs(board,x + dx[i],y + dy[i]);
                    }
                }else {
                    //有地雷,显示地雷个数
                    board[x][y] = (char) (count + '0');
                }
            }else if(board[x][y] == 'M'){
                board[x][y] = 'X';
            }
        }

    }

    public int judge(char[][] board, int x, int y){
        int r = board.length;
        int c = board[0].length;
        int count = 0;
        for (int i = 0; i < dx.length; i++) {
            int newX= x + dx[i];
            int newY = y + dy[i];
            if(newX >=0 && newX < r && newY >=0 && newY < c){
                if(board[newX][newY] == 'M'){
                    count++;
                }
            }
        }
        return count;
    }
}
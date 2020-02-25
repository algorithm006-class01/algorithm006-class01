//529. 扫雷游戏
//https://leetcode-cn.com/problems/minesweeper/description/

/* 字母的含义
 * M: 未挖的地雷
 * E: 未挖的空块
 * B: 四个对角线都没有地雷, 挖出方块
 * 1-8: 表示附近有多少地雷
 */ 

//需要一个坐标记录是否访问， 避免无效搜索
//四面八方的搜索，而不是上下左右
class Solution {
public:
    int dx[8] = {-1,-1,-1, 0, 0, 1, 1, 1};
    int dy[8] = { 1, 0,-1, 1,-1, 1, 0, -1};
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        int row = click[0];
        int col = click[1];
        //访问记录
        vector<vector<bool>> visited( board.size(), 
        vector<bool>(board[0].size(), false) );
        if(board[row][col] == 'M'){
            board[row][col] = 'X';
        } else{
            DFS(row, col, board, visited);
        }
        return board;
    }
    void DFS(int row, int col, vector<vector<char>>& board, vector<vector<bool>>&  visited){
        visited[row][col] = true;

        //统计附近是否有雷, 有雷就返回
        int mn = findMine(row, col, board);
        if ( mn > 0 ) {
            board[row][col] = '0' + mn;
            return ;
        }
        //没有雷就移动
        board[row][col] = 'B';
        for (int k = 0; k < 8; k++){
            int x = row + dx[k], y = col + dy[k];
            if ( x >= 0 && x < board.size() && y >= 0 && y < board[0].size() && \
                    board[x][y]=='E' && !visited[x][y]){
                DFS(x, y, board, visited);
            }
        }
    }
    int findMine(int row, int col, vector<vector<char>>& board){
        //左上、左、左下、上、下、右上、右、右下
        int count = 0;
        for (int i = 0; i < 8; i++){
            int x = row + dx[i], y = col + dy[i];
            if ( x >= 0 && x < board.size() && y >= 0 && y < board[0].size()){
            if ( board[x][y] == 'M') count+=1; //有雷+1
            }
        }
        return count;
    }
};

/*
[["E","E","E","E","E","E","E","E"],
 ["E","E","E","E","E","E","E","M"],
 ["E","E","M","E","E","E","E","E"],
 ["M","E","E","E","E","E","E","E"],
 ["E","E","E","E","E","E","E","E"],
 ["E","E","E","E","E","E","E","E"],
 ["E","E","E","E","E","E","E","E"],
 ["E","E","M","M","E","E","E","E"]]
[0,0]


[["B","B","B","B","B","B","1","E"],
 ["B","1","1","1","B","B","1","M"],
 ["1","E","M","1","B","B","1","1"],
 ["M","E","1","1","B","B","B","B"],
 ["1","1","B","B","B","B","B","B"],
 ["B","B","B","B","B","B","B","B"],
 ["B","1","2","2","1","B","B","B"],
 ["B","1","M","M","1","B","B","B"]]

[["B","B","B","B","B","B","1","E"],
 ["B","1","1","1","B","B","1","M"],
 ["1","2","M","1","B","B","1","1"],
 ["M","2","1","1","B","B","B","B"],
 ["1","1","B","B","B","B","B","B"],
 ["B","B","B","B","B","B","B","B"],
 ["B","1","2","2","1","B","B","B"],
 ["B","1","M","M","1","B","B","B"]]
*/
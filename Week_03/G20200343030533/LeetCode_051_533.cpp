//51. N皇后
// https://leetcode-cn.com/problems/n-queens/

//51. N皇后
// https://leetcode-cn.com/problems/n-queens/

class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        
        vector<vector<string>> res;
        if (n < 1) return res;

        set<int> cols;
        set<int> pie;
        set<int> na;
     
        vector<int> curr;

        DFS(n, 0, cols, pie , na, curr, res);

        return res;

    }
    void DFS(int n, int row, set<int>& cols, set<int>& pie, set<int>& na, vector<int>& curr, vector<vector<string>>& res){
        if (row >= n){
            res.push_back(generate_result(curr, n));
            return ;
        }

        for (int col = 0; col < n; col++){
            if ( cols.count(col) > 0 || pie.count(row+col) >0 || na.count(row-col) >0 ) {
                continue;
            }
            cols.insert(col);
            pie.insert(row+col);
            na.insert(row-col);

            curr.push_back(col);
            DFS(n, row+1, cols, pie, na, curr, res);
            // reverse
            curr.pop_back();
            cols.erase(col);
            pie.erase(row+col);
            na.erase(row-col);


        }

    }
    //产生结果
    vector<string> generate_result(vector<int>& curr, int n){
        vector<string> res;
        for (int i = 0; i < curr.size(); i++){
            string tmp ;
            for (int j = 0; j < curr[i]; j++){
                tmp += ".";
            }
            tmp += "Q";
            for (int j = curr[i]+1; j < n; j++){
                tmp += ".";
            }
            res.push_back(tmp);
        }
        return res;

    }
};
class Solution {
//更加简洁的方法
private:
    vector<string> board;
    vector<vector<string>> ans;
    /*
     *@param board: 棋盘
     *@param pos: 当前位置
     *@param depth: 深度，也就是所在行
     *@param n:  皇后数
     */
    void solve(vector<string>& board, vector<int>& pos, int depth, int n){
        if (depth == n){
            ans.push_back(board);
            return ;
        }
        for (int i = 0; i < n ; i++){
            pos[depth] = i;
            if (valid(pos, depth)){
                board[depth][i] = 'Q';
                solve(board, pos, depth + 1, n);
                board[depth][i] = '.';
            }
        }
    }
    //列相同最容易判断
    //主要是对角线判断
    //对角线 y = |x|, y-y0 = | x-x0 |
    bool valid(vector<int> pos, int curLen){
        //检查之前的皇后影响
        for (int i = 0; i < curLen; i++){
            if ( pos[i] == pos[curLen] || abs(pos[i] - pos[curLen]) == curLen - i){
                return false;
            }
        }
        return true;
    }
public:
    vector<vector<string>> solveNQueens(int n){
        //初始化棋盘
        string row(n, '.');
        for (int i = 0; i <n ;i++){
            board.push_back(row);
        }
        //记录皇后占据的位置
        vector<int> pos = vector<int>(n);
        solve(board, pos, 0, n);
        return ans;
    }
}
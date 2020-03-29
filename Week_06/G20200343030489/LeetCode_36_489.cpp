/*
 * @lc app=leetcode.cn id=36 lang=cpp
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int row[9][10]={0};
        int col[9][10]={0};
        int box[9][10]={0};
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                    continue;
                int curNum=board[i][j]-'0';
                if(row[i][curNum])
                    return  false;
                if(col[j][curNum])
                    return false;
                if(box[j/3+(i/3)*3][curNum])
                    return false;
                row[i][curNum]=1;
                col[j][curNum]=1;
                box[j/3+(i/3)*3][curNum]=1;
            }
        }
        return true;
    }
};
// @lc code=end


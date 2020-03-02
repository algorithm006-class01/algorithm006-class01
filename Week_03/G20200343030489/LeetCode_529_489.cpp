/*
 * @lc app=leetcode.cn id=529 lang=cpp
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution
{
public:
    vector<vector<char>> updateBoard(vector<vector<char>> &board, vector<int> &click)
    {
        if (board[click[0]][click[1]] == 'M')
        {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs_(board, click[0], click[1]);
        return board;
    }

    void dfs_(vector<vector<char>> &board, int x, int y)
    {
        if (!judge(x, y, board))
            return;
        vector<vector<int>> v = {{1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}};
        int count = 0;
        if (board[x][y] == 'E')
        {
            for (int i = 0; i < 8; i++)
            {
                if (judge(x + v[i][0], y + v[i][1], board) && board[x + v[i][0]][y + v[i][1]] == 'M')
                    count++;
            }
            if (count > 0)
                board[x][y] = '0' + count;
            else
            {
                board[x][y] = 'B';
                for (int i = 0; i < 8; i++)
                {
                    dfs_(board, x + v[i][0], y + v[i][1]);
                }
            }
        }
    }

    bool judge(int x, int y, vector<vector<char>> board)
    {
        return x >= 0 && x < board.size() && y >= 0 && y < board[0].size();
    }
};
// @lc code=end

/*
 * @lc app=leetcode.cn id=200 lang=cpp
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution
{
public:
    int numIslands(vector<vector<char>> &grid)
    {
        int row = grid.size(), col = row ? grid[0].size() : 0, islands = 0;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (grid[i][j] == '1')
                {
                    islands++;
                    dfs_(grid, i, j);
                }
            }
        }
        return islands;
    }
    void dfs_(vector<vector<char>> &grid, int i, int j)
    {
        int row = grid.size(), col = grid[0].size();
        if (i < 0 || i == row || j < 0 || j == col || grid[i][j] == '0')
        {
            return;
        }
        grid[i][j] = '0';
        dfs_(grid, i - 1, j);
        dfs_(grid, i + 1, j);
        dfs_(grid, i, j - 1);
        dfs_(grid, i, j + 1);
    }
};
// class Solution
// {
// public:
//     int numIslands(vector<vector<char>> &grid)
//     {
//         int row = grid.size(), col = row ? grid[0].size() : 0, islands = 0, offsets[] = {0, 1, 0, -1, 0};
//         for (int i = 0; i < row; i++)
//         {
//             for (int j = 0; j < col; j++)
//             {
//                 if (grid[i][j] == '1')
//                 {
//                     islands++;
//                     grid[i][j] = '0';
//                     queue<pair<int, int>> que;
//                     que.push({i, j});
//                     while (!que.empty())
//                     {
//                         pair<int, int> p = que.front();
//                         que.pop();
//                         for (int k = 0; k < 4; k++)
//                         {
//                             int r = p.first + offsets[k], c = p.second + offsets[k + 1];
//                             if (r >= 0 && r < row && c >= 0 && c < col && grid[r][c] == '1')
//                             {
//                                 grid[r][c] = '0';
//                                 que.push({r, c});
//                             }
//                         }
//                     }
//                 }
//             }
           
//         }
//          return islands;
//     }
// };
// @lc code=end

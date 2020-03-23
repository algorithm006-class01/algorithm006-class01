/*
 * @lc app=leetcode.cn id=773 lang=cpp
 *
 * [773] 滑动谜题
 */

// @lc code=start
class Solution
{
public:
    int slidingPuzzle(vector<vector<int>> &board)
    {
        string target = "123450";
        string begin = to_string(board[0][0]) + to_string(board[0][1]) + to_string(board[0][2]) + to_string(board[1][0]) + to_string(board[1][1]) + to_string(board[1][2]);
        vector<vector<int>> nextMoves{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        unordered_set<string> visited{begin};
        queue<string> que;
        que.push(begin);
        for (int depth = 0; !que.empty(); depth++)
        {
            int size = (int)que.size();
            for (int i = 0; i < size; i++)
            {
                auto curr = que.front();
                que.pop();
                if (curr == target)
                    return depth;
                int zero = (int)curr.find("0");
                for (auto next : nextMoves[zero])
                {
                    auto candidate = curr;
                    swap(candidate[zero], candidate[next]);
                    if (visited.find(candidate) == visited.end())
                    {
                        visited.insert(candidate);
                        que.push(candidate);
                    }
                }
            }
        }
        return -1;
    }
};
// @lc code=end

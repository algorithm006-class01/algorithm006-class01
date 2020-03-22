/*
 * @lc app=leetcode.cn id=367 lang=cpp
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution
{
public:
    bool isPerfectSquare(int num)
    {
        long long i = 0;
        long long j = num / 2 + 1;
        while (i <= j)
        {
            long long mid = (i + j) / 2;
            long long res = mid * mid;
            if (res == num)
                return true;
            else if (res < num)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return false;
    }
};
// @lc code=end

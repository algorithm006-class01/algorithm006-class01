#include <vector>

using namespace std;

class Solution
{
public:
    int lengthOfLIS(vector<int> &nums)
    {
        int len = nums.size();
        if (len < 2)
        {
            return len;
        }

        int dp[len];
        fill(dp, dp + len, 1);

        for (int i = 1; i < len; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[j] < nums[i])
                {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++)
        {
            res = max(res, dp[i]);
        }
        return res;
    }
};

#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

class Solution
{
public:
    int longestValidParentheses(string s)
    {
        int maxLen = 0;
        vector<int> dp(s.length());

        for (int i = 1; i < s.length(); i++)
        {
            if (s[i] == ')')
            {
                if (s[i - 1] == '(')
                {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 and s[i - dp[i - 1] - 1] == '(')
                {
                    dp[i] = (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
            }
            maxLen = fmax(dp[i], maxLen);
        }
        return maxLen;

    }
};


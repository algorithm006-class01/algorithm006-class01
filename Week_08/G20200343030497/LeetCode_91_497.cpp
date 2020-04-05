class Solution {
public:
    // 动态规划
    int numDecodings(string s) {
        int dp2 = 1; 
        int dp1 = s.back() == '0' ? 0 : 1;
        int dp = dp1;

        for (int i=s.size()-2; i>=0; --i) {
            if (s[i]=='0') {
                dp=0;
            } else {
                dp = dp1;
                if (s[i]=='1' || s[i]=='2' && s[i+1] <='6') {
                    dp += dp2;
                }
            }
            dp2 = dp1;
            dp1 = dp;
        }

        return dp;
    }
};

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int countSubstrings(string s) {
        if(s.empty())
            return 0;
        int size=s.size();
        int res=0;

        vector<vector<bool>> dp(size,vector<bool >(size));
        for(int i=size-1;i>=0;i--)
        {
            for(int j=i;j<size;j++)
            {
                dp[i][j]=(s[i]==s[j]) &&(j-i<=2 || dp[i+1][j-1]);
                if(dp[i][j])
                    res++;
            }
        }
        return res;
    }
};
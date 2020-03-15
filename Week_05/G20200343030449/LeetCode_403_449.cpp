class Solution {
public:
    bool canCross(vector<int>& stones) {
        unordered_set<int> h;
        for(auto x:stones) h.insert(x);
        unordered_map<long long, bool> dp;
        
        for(int i = 1 ; i <= 1001 ; i ++)
            if(dfs(stones.back(),i,h,dp))
                return true;
        return false;
    }

    bool dfs(int x, int y, unordered_set<int> &h, unordered_map<long long, bool> &dp) {
        if(y<=0 || !h.count(x)) return false;
        if(x==1&&y==1) return true;
   
        long long t = (long long)x<<32|y;
        if(dp.count(t)) return dp[t];
        
        if(dfs(x-y,y,h,dp)||dfs(x-y,y-1,h,dp)||dfs(x-y,y+1,h,dp))
            return dp[t] = true;
        return dp[t] = false;
    };
};

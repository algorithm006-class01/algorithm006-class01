class Solution {
    vector<int> nums;
    vector<vector<int>> res;
    vector<int> v;
    void dfs(long long state, long long last)
    {
        if(state == ((1 << nums.size()) - 1))
        {
            res.push_back(v);
            return;
        }
        for(long long i = 0; i < nums.size(); i++)
        {
            if(!((1 << i) & state))
            {
                state ^= (1 << i);
                v.push_back(nums[i]);
                dfs(state, nums[i]);
                state ^= (1 << i);
                v.pop_back();
            }
        }
    }
public:
    vector<vector<int>> permute(vector<int>& _nums) {
        nums = _nums;
        long long state = 0, last = 0;
        sort(nums.begin(), nums.end());
        dfs(state, last);
        return res;
    }
};

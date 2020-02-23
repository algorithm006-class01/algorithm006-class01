class Solution {
public:
    void backtrace(map<int, int>& m, int k, int n,
                   vector<int>& v, vector<vector<int> >& res) {
        if (k == n) {
            res.push_back(v);
            return;
        }
        for (auto& p : m) {
            if (p.second == 0) continue;
            --p.second;
            v.push_back(p.first);
            backtrace(m, k + 1, n, v, res);
            ++p.second;
            v.pop_back();
        }
    }
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        map<int, int> m;
        for (auto x : nums) ++m[x];
        vector<vector<int> > res;
        vector<int> v;
        backtrace(m, 0, nums.size(), v, res);
        return res;
    }
};

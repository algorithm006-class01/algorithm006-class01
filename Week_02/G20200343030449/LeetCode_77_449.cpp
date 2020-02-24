class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> result;
        vector<int> combine;

        _combine(1, combine, n, k, result);

        return result;
    }

    void _combine(unsigned int start, vector<int> combined, const int MAX_NUM, const int k, vector<vector<int>>& ret) {
        // terminate
        if (combined.size()==k) {
            ret.push_back(combined);
            return;
        }

        for (int i = start; i < MAX_NUM+1; i++) {
            combined.push_back(i);
            _combine(++start, combined, MAX_NUM, k, ret);
            combined.pop_back();
        }

        // other status
        return;
    }
};

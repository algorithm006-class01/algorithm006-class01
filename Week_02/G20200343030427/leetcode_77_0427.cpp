class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combine(int n, int k) {
        if (n < k) return result;
        vector<int> arr(k, 0);
        combine(n, k, 0, 0, arr);
        return result;
    }
    void combine(int n, int k, int n_pos, int k_pos, vector<int>& arr) {
        if (n - n_pos < k - k_pos) return;
        if (k_pos == k) {
            result.emplace_back(arr);
            return;
        }
        arr[k_pos] = n_pos + 1;                  
        combine(n, k, n_pos + 1, k_pos+1, arr);  
        combine(n, k, n_pos + 1, k_pos, arr);   
    }
};

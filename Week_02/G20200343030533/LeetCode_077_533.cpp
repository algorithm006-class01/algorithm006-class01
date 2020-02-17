// 77. 组合
// https://leetcode-cn.com/problems/combinations/

class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> ret;
        vector<int> comb;
        generate(0, 1, n, k, comb, ret );
        return ret;
    }
    void generate(int depth, int start, int n, int k, vector<int>& comb, vector<vector<int>>& ret){
        if ( depth == k){
            ret.push_back(comb);
        }
        for (int i = start; i <= n; i++){
            comb.push_back(i);
            generate(depth+1, i+1, n, k, comb, ret);
            //reverse
            comb.pop_bakc();
        }


    }
};
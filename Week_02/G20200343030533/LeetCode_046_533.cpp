// 46. 全排列 ii
// https://leetcode-cn.com/problems/permutations-i/ 

class Solution {
public:
    int idx = 0;
    vector<vector<int>> permute(vector<int>& nums) {
        int perm_nums = 1;
        for (int i = 1; i <= nums.size(); i++) perm_nums *= i;
        //预先分配内存
        vector<vector<int>> ret(perm_nums, vector<int>(nums.size(), 0));
        //表示使用状态
        vector<bool> used(nums.size(), false);
        //当前的组合
        vector<int> perm(nums.size());

        generate(0, perm, nums, used, ret);
        return ret;

    }
    /* 参数说明:
    * depth: 表示当前的深度
    * num: 当前的组合
    * nums: 给定的数组
    * used: 使用情况
    * idx : 
    */
    void generate(int depth, vector<int>&perm, vector<int>& nums, vector<bool>& used, vector<vector<int>>& ret){
        if ( depth == nums.size() ) {
            ret[idx] = perm;
            idx+=1;
            return ;
        }
        // 做选择
        for(int i = 0; i < nums.size(); i++){
            // 当前数字没有被使用, 没有用过是false
            if ( ! used[i] ) {
                used[i] = true;
                perm[depth] = nums[i];
                generate(depth+1, perm, nums, used, ret);
                //重置状态
                used[i] = false;
            }

        }

    }
};
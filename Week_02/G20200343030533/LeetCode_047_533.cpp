// 47. 全排列 II
//https://leetcode-cn.com/problems/permutations-ii/

class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
         //输出结果
        vector<vector<int>> ret;
        //表示使用状态
        vector<bool> used(nums.size(), false);
        //当前的组合
        vector<int> perm(nums.size());
        generate(0, perm, nums, used, ret);

        return ret;

    }
    /* 参数说明:
    * depth: 表示当前的深度
    * perm: 当前的组合
    * nums: 给定的数组
    * used: 使用情况
    */
    void generate(int depth, vector<int>&perm, vector<int>& nums, vector<bool>& used, vector<vector<int>>& ret){
        if ( depth == nums.size() ) {
            ret.push_back( perm );
            return ;
        }
        // 做选择
        for(int i = 0; i < nums.size(); i++){
            // 当前数字没有被使用, 没有用过是false
            if (  used[i] ) continue;
            if ( i> 0 && nums[i] == nums[i-1] && ! used[i-1] ) continue;

            used[i] = true;
            perm[depth] = nums[i];
            generate(depth+1, perm, nums, used, ret);
            //重置状态
            used[i] = false;
            

        }

    }
};
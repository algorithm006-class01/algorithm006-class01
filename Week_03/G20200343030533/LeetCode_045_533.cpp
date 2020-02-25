//https://leetcode-cn.com/problems/jump-game-ii/

//局部贪心法，
//每次跳之前，分析后续可抵达位置，选择后面位置最大的哪一个

class Solution {
public:
    int jump(vector<int>& nums) {
        int step = 0;
        int end = 0;
        int maxPos = 0; //最远抵达的位置
        for (int i = 0; i < nums.size() - 1; i++){
            maxPos = max(nums[i] + i, maxPos);
            if ( i == end ){
                end = maxPos; //更新最远的位置
                step++;
            }
        }
        return step;

    }
};
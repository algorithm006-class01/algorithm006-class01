// 两数之和: https://leetcode-cn.com/problems/two-sum/submissions/
#include <iostream>
#include <unordered_map>
#include <vector>

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> idx_map;
        vector<int> result = {0,0};
        for ( int i = 0; i < nums.size(); i++){
            if (idx_map.count(target - nums[i]) > 0){
                result[0] = i;
                result[1] = idx_map[target-nums[i]];
                break;
            } else{
                idx_map[nums[i]] = i;
            }
        }
        return result; 
    }
};
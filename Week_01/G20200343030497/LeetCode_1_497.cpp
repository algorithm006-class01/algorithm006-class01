/*
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */

class Solution {
public:
    // 利用哈希表，用空间换时间
    // 时间复杂度：O(n)，只需遍历一遍数组
    // 空间复杂度：O(n)，存储数据中的元素
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        unordered_map<int, int> vmap;  // 存储<值，建>
        int length = nums.size();
        int another; // 存储在字典中，another = target - current
        vmap[nums[0]] = 0;

        for(int i=1; i<length; i++){
            another = target - nums[i];
            if(vmap.find(another) != vmap.end() && vmap[another] != i){  // 判断是否存在
                result.push_back(vmap[another]);
                result.push_back(i);
                return result;
            }

            vmap[nums[i]] = i;
        }

        return result;
    }

    // 暴力法
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    vector<int> twoSum1(vector<int>& nums, int target) {
        vector<int> v;
        int length = nums.size();
        for(int i=0; i<length-1; i++){
            for(int j=i+1; j<length; j++){
                if(nums[i] + nums[j] == target){
                    v.push_back(i);
                    v.push_back(j);
                }
            }
        }
        return v;
    }
};
// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/

//暴力
class Solution {
public:
    int findMin(vector<int>& nums) {

        int min = INT_MAX;
        int n = nums.size();

        for (int i = 0; i < n; i++){
            if (nums[i] < min) min = nums[i];
        }
        return min;

    }
};
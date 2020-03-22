/*
 * @lc app=leetcode.cn id=153 lang=cpp
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution
{
public:
    int findMin(vector<int> &nums)
    {
        if(nums.back()>nums[0])
            return nums[0];
        int start=0,end=nums.size()-1;
        while(start<end){
            int mid=start+end>>1;
            if(nums[mid]<nums[0])
                end=mid;
            else
                start=mid+1;
        }
        return nums[end];
        
    }
};
// @lc code=end

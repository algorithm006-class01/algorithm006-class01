/*
 * @lc app=leetcode.cn id=33 lang=cpp
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution
{
public:
    int search(vector<int> &nums, int target)
    {
        int start=0,end=nums.size()-1;
        while(start<end){
            int mid=(start+end)/2;
            if((nums[0]>target)^(nums[0]>nums[mid])^(target>nums[mid]))
                start=mid+1;
            else
                end=mid;
            
        }
        return start==end&&nums[start]==target?start:-1;
    }
};
// @lc code=end

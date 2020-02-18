/*
 * @lc app=leetcode.cn id=283 lang=swift
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    func moveZeroes(_ nums: inout [Int]) {
        guard nums.count > 0 else {
            return
        }
        
        var notZeroIndex = 0
        for index in 0..<nums.count{
            if(nums[index] != 0){
                nums[notZeroIndex] = nums[index]
                notZeroIndex += 1
            }
        }

        for i in notZeroIndex..<nums.count{
            nums[i] = 0
        }
        
    }
}
// @lc code=end


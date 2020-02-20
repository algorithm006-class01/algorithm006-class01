/*
 * @lc app=leetcode.cn id=189 lang=swift
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    func rotate(_ nums: inout [Int], _ k: Int) {
        guard nums.count > 1, k > 0 else {
            return
        }
        
        let interval = k % nums.count
        reverse(&nums, start: 0, end: nums.count)
        reverse(&nums, start: 0, end: interval)
        reverse(&nums, start: interval, end: nums.count)
    }
    
    func reverse(_ nums: inout[Int], start: Int, end: Int){
        guard nums.count > 0, end > start, nums.count >= end else {
            return
        }
        
        var left = start;
        var right = end - 1
        while(left < right){
            var temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            
            left += 1
            right -= 1
        }
    }
}
// @lc code=end


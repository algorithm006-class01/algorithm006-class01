/*
 * @lc app=leetcode.cn id=1 lang=swift
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        for i in 0..<nums.count {
            for j in (i+1)..<nums.count{
                if nums[i] + nums[j] == target {
                    return [i, j]
                }
            }
        }
        return [0, 0]
    }
}
// @lc code=end


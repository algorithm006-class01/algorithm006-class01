/*
 * @lc app=leetcode.cn id=1 lang=swift
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var map = [Int:Int]()
        map[nums[0]] = 0
        for i in 1..<nums.count {
            if let index = map[target - nums[i]] {
                return [index, i]
            }else{
                map[nums[i]] = i
            }
        }
        return [0, 0]
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=11 lang=swift
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    func maxArea(_ heights: [Int]) -> Int {
        var areas = [Int]()
        for i in 0..<heights.count {
            for j in (i+1)..<heights.count {
                let h = heights[i] < heights[j] ? heights[i] : heights[j]
                let width = j - i
                areas.append(h*width)
            }
        }
        return areas.max()!
    }
}
// @lc code=end


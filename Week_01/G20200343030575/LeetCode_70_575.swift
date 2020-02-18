/*
 * @lc app=leetcode.cn id=70 lang=swift
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    func climbStairs(_ n: Int) -> Int {
        guard n != 1 else {
            return 1
        }
        guard n != 2 else {
            return 2
        }
        
        var results = Array<Int>.init(repeating: 1, count: n+1)
        results[1] = 1
        results[2] = 2
        for i in 2...n {
            results[i] = results[i-1] + results[i-2]
        }
        return results[n]
    }
}
// @lc code=end


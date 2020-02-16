/*
 * @lc app=leetcode.cn id=66 lang=swift
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    func plusOne(_ digits: [Int]) -> [Int] {
        var result = digits
        for i in (0..<result.count).reversed() {
            result[i] += 1
            if result[i] == 10 {
                result[i] = 0
            }else{
                break
            }
        }
        
        if result[0] == 0 {
            result.insert(1, at: 0)
        }
        return result
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=455 lang=swift
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    func findContentChildren(_ g: [Int], _ s: [Int]) -> Int {
        var result = 0
        let greedFactors = g.sorted()
        let sizes = s.sorted()
        
        var greedIndex = 0, sizeIndex = 0
        let greedFactorsCount = greedFactors.count
        let sizesCount = sizes.count
        while greedIndex < greedFactorsCount && sizeIndex < sizesCount {
            if greedFactors[greedIndex] <= sizes[sizeIndex] {
                greedIndex += 1
                sizeIndex += 1
                result += 1
            }else{
                //饼干太小，不能满足了
                sizeIndex += 1
            }
        }
        return result
    }
}

// @lc code=end


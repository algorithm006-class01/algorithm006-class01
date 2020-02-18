/*
 * @lc app=leetcode.cn id=26 lang=swift
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    func removeDuplicates(_ nums: inout [Int]) -> Int {
        guard nums.count > 1 else{
            return nums.count
        }
        
        var result = 0
        for i in 1..<nums.count {
            if nums[i] != nums[i-1] {
                result += 1
                nums[result] = nums[i]
            }
        }
        
        return result + 1
    }
}

//这道题虽然简单，但是在第17和18行的位置颠倒了，返回值result+1，而不是result。
//我的问题是，这道题目有161个测试用例，如果是我，怎么构造出这么多测试用例？

// @lc code=end


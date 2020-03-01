/*
 * @lc app=leetcode.cn id=88 lang=swift
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
        var firstIndex = m - 1, secondIndex = n - 1
        var index = m + n - 1
        while firstIndex >= 0 && secondIndex >= 0 {
            if nums1[firstIndex] >= nums2[secondIndex] {
                nums1[index] = nums1[firstIndex]
                firstIndex -= 1
            }else{
                nums1[index] = nums2[secondIndex]
                secondIndex -= 1
            }
            index -= 1
        }
        
        while secondIndex >= 0 {
            nums1[index] = nums2[secondIndex]
            secondIndex -= 1
            index -= 1
            
        }
    }
}


// @lc code=end


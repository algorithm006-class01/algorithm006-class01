//
//  0300_LongestIncreasingSubsequence.swift
//  AlgorithmPractice
//
//  Created by Ryeagler on 2020/3/14.
//  https://leetcode-cn.com/problems/longest-increasing-subsequence/
//  第2遍总结：
//      dp[i]的意义是：i选中的情况下，最长的子序列
//      转移方程是在num[i] > num[i]的条件下转移dp[i] = max(dp[i], dp[j] + 1)，其中dp[i]初始值是1
//  第3遍总结：
//
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class LongestIncreasingSubsequence {
    
    //MARK: 复杂度为O(N^2)
    func lengthOfLIS(_ nums: [Int]) -> Int {
        if nums.count == 0 {
            return 0
        }
        var dp = [Int](repeating: 1, count: nums.count)
        var result = 1

        for i in 1..<nums.count {
            for j in 0..<i {
                if nums[i] > nums[j] {
                    dp[i] = max(dp[i], dp[j] + 1)
                }
            }
            result = max(result, dp[i])
        }
        return result
    }
    
    //MARK: 复杂度为O(NlogN)
    func lengthOfLIS_NLogN(_ nums: [Int]) -> Int {
        var tails = [Int](repeating: 0, count: nums.count)
        var size = 0
        for num in nums {
            var i = 0, j = size
            while i != j {
                let m = (i + j) / 2
                if tails[m] < num {
                    i = m + 1
                } else {
                    j = m
                }
            }
            tails[i] = num
            if i == size { size += 1 }
        }
        return size
    }
}

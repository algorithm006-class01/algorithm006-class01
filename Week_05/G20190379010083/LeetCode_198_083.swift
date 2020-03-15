//
//  0198_HouseRobber.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/house-robber/
//  第一遍总结：
//      创建一个count + 1的数组，省去之前的一些判断条件
//  Created by Ryeagler on 2020/3/15.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class HouseRobber {
    func rob(_ nums: [Int]) -> Int {
        if nums.count == 0 {
            return 0
        }
        var dp = [Int](repeating: 0, count: nums.count + 1)
        dp[0] = 0
        dp[1] = nums[0]
        for i in 1..<nums.count {
            dp[i + 1] = max(dp[i], dp[i - 1] + nums[i])
        }
        return dp[nums.count]
    }
}

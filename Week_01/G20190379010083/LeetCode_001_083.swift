//
//  0001_2sum.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/two-sum/
//  Created by Ryeagler on 2020/2/14.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

    // 暴力求解
    func twoSumBruteForce(_ nums: [Int], _ target: Int) -> [Int] {
        for i in stride(from: 0, to: nums.count, by: 1) {
            for j in stride(from: i + 1, to: nums.count, by: 1) {
                if nums[i] + nums[j] == target {
                    return [i, j]
                }
            }
        }
        return []
    }

    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var map: [Int: Int] = [Int: Int]()
        for i in stride(from: 0, to: nums.count, by: 1) {
            let current = nums[i]
            let another = target - current
            if map[another] != nil {
                return [i, map[another]!]
            }
            map.updateValue(i, forKey: nums[i])
        }
        return []
    }

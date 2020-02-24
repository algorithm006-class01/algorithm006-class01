//
//  0015_3num.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/3sum/
//  Created by Ryeagler on 2020/2/12.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class ThreeSum {
    // 暴力方式虽然能解出所有三个数和为0的数组，但是不符合题目中要求的不能包含重复的三元组这个条件
    func threeSumBruteForce(_ nums: [Int]) -> [[Int]] {
        var result = [[Int]]()
        for i in stride(from: 0, to: nums.count, by: 1) {
            for j in stride(from: i + 1, to: nums.count, by: 1) {
                for k in stride(from: j + 1, to: nums.count, by: 1) {
                    if nums[i] + nums[j] + nums[k] == 0 {
                        var arr = [Int]()
                        // 错误加下标
                        arr.append(nums[i])
                        arr.append(nums[j])
                        arr.append(nums[k])
                        result.append(arr)
                        break
                    }
                }
            }
        }
        return result
    }
    
    // 这个解法最后还是没有通过leetcode的方法
    func threeSumHashMap(_ nums: [Int]) -> [[Int]] {
        var map: [Int: Int] = [Int: Int]()
        for i in stride(from: 0, to: nums.count, by: 1) {
            map.updateValue(i, forKey: nums[i])
        }
        
        var result: [[Int]] = [[Int]]()
        var resultMap: [[Int]: Bool] = [[Int]: Bool]()
        for i in stride(from: 0, to: nums.count, by: 1) {
            for j in stride(from: i + 1, to: nums.count, by: 1) {
                let another = 0 - (nums[i] + nums[j])
                if map[another] != nil {
                    // 少了这一步，就会导致3元组中，同一个下标对应的数字出现多次
                    if map[another] == i || map [another] == j {
                        continue
                    }
                    let arr = [nums[i], nums[j], another].sorted()
                    
                    // 这一步是为了去除重复的
                    if resultMap[arr] == true {
                        continue
                    }
                    result.append(arr)
                    resultMap.updateValue(true, forKey: arr)
                }
            }
        }

        return result
    }
    
    func threeSum(_ nums: [Int]) -> [[Int]] {
        if nums.count < 3 {
            return []
        }
        var result = [[Int]]()
        let sortedNums = nums.sorted()
        for var i in 0..<sortedNums.count {
            if sortedNums[0] > 0 {
                return []
            }
            let last = sortedNums.count - 1
            while i + 1 < last && sortedNums[i] == sortedNums[i+1] {
                i += 1
            }
            var left = i + 1
            var right = last
            while left < right {
                let sum = sortedNums[i] + sortedNums[left] + sortedNums[right]
                if sum == 0 {
                    result.append([sortedNums[i], sortedNums[left], sortedNums[right]])
                }
                if sum <= 0 {
                    repeat {
                        left += 1
                    } while left < last && sortedNums[left] == sortedNums[left - 1]
                } else {
                    repeat {
                        right -= 1
                    } while right > 0 && sortedNums[right] == sortedNums[right + 1]
                }
            }
        }
        return result
    }
}

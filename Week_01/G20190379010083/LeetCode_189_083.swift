//
//  0189_RotateArray.swift
//  AlgorithmPractice
//
//  Created by Ryeagler on 2020/2/16.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class RotateArray {
    /// 三次反转法，时间复杂度为O(n)，空间复杂度为O(1)
    func rotate(_ nums: inout [Int], _ k: Int) {
        if k < 0 {return}
        // 题目中要求是向右移动k位，最初没有考虑到k大于数组长度的情况
        reverse(&nums, 0, nums.count - 1)
        reverse(&nums, 0, k % nums.count - 1)
        reverse(&nums, k % nums.count, nums.count - 1)
    }
    
    /// 通过额外的空间反转，时间复杂度为O(n)，空间复杂度为O(1)
    func rotateAnotherArray(_ nums: inout [Int], _ k: Int) {
        var tmpNums = [Int](repeating: 0, count: k)
        for i in 0..<nums.count {
            tmpNums[(i + k) % nums.count] = nums[i]
        }
        
        for i in 0..<nums.count {
            nums[i] = tmpNums[i]
        }
    }
    
    /// 暴力解法真的好难
    func rotateBruteForce(_ nums: inout [Int], _ k: Int) {
        var tmp = 0
        var previous = 0
        for _ in 0..<k {
            previous = nums[nums.count - 1]
            for j in 0..<nums.count {
                tmp = nums[j]
                nums[j] = previous
                previous = tmp
            }
        }
    }
    
    // MARK: Private Methods
    func reverse(_ nums: inout [Int], _ start: Int, _ end: Int) {
        if start < 0 || end >= nums.count {
            return
        }
        var left = start
        var right = end
        while left < right {
            let tmp = nums[left]
            nums[left] = nums[right]
            nums[right] = tmp
            left += 1
            right -= 1
        }
    }
}

//
//  0283_MoveZeros.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/move-zeroes/
//  Created by Ryeagler on 2020/2/11.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class MoveZerosSolution {
    /// 两遍循环法
    func moveZeroes(_ nums: inout [Int]) {
        var countOfNozero = 0
        for i in stride(from: 0, to: nums.count, by: 1) {
            if nums[i] != 0 {
                nums[countOfNozero] = nums[i]
                countOfNozero += 1
            }
        }

        for i in stride(from: countOfNozero, to: nums.count, by: 1) {
            nums[i] = 0
        }
    }
    
    /// 一次循环：快排思想
    func moveZeroesQs(_ nums: inout [Int]) {
        // 第一个指针到那些需要移动前面的数
        // 第二个指针找到将要交换
        var j = 0
        for i in stride(from: 0, to: nums.count, by: 1) {
            if (nums[i] != 0) {
                let tmp = nums[i]
                nums[i] = nums[j]
                nums[j] = tmp
                j += 1
            }
        }
    }
    
    /// 快速分割
    func qsDivide(_ nums: inout [Int]) {
        if nums.count <= 0 {
            return
        }
        let right = nums.count - 1
        let pivot = nums[right]
        var j = 0
        for i in stride(from: 0, to: nums.count - 1, by: 1) {
            if nums[i] <= pivot {
                let tmp = nums[i]
                nums[i] = nums[j]
                nums[j] = tmp
                j += 1
            }
        }
        let tmp = nums[right]
        nums[right] = nums[j]
        nums[j] = tmp
    }
}

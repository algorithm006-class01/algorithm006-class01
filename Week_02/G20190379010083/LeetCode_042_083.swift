//
//  0042_TrappingRainWater.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/trapping-rain-water/
//  Created by Ryeagler on 2020/2/15.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class TrappingRainWater {
    /// 左右指针
    func trap(_ height: [Int]) -> Int {
        var result = 0
        var left = 0, right = height.count - 1
        var leftMax = 0, rightMax = 0
        while left < right {
            if height[left] < height[right] {
                if height[left] >= leftMax {
                    leftMax = height[left]
                } else {
                    result += leftMax - height[left]
                }
                left += 1
            } else {
                if height[right] >= rightMax {
                    rightMax = height[right]
                } else {
                    result += rightMax - height[right]
                }
                right -= 1
            }
        }
        return result
    }
    
    /// 栈法
    func trapStack(_ height: [Int]) -> Int {
        var result = 0
        var stack = Stack<Int>()
        var i = 0
        while i < height.count {
            if stack.isEmpty || height[i] <= height[stack.peek()!] {
                stack.push(i)
                i += 1
            } else {
                //
                let pre = stack.pop()!
                if stack.isEmpty == false {
                    let minHeight = min(height[stack.peek()!], height[i])
                    result += (minHeight - height[pre]) * (i - stack.peek()! - 1)
                }
            }
        }
        return result
    }
    
    /// 动态法
    func trapDanamic(_ height: [Int]) -> Int {
        var result = 0
        var leftMaxArr = [Int]()
        var rightMaxArr = [Int]()
        
        var leftMax = 0
        for i in 0..<height.count {
            leftMax = max(leftMax, height[i])
            leftMaxArr.append(leftMax)
        }
        
        var rightMax = 0
        for i in stride(from: height.count - 1, through: 0, by: -1) {
            rightMax = max(rightMax, height[i])
            // 这里之前犯错了，写成了append了
            rightMaxArr.insert(rightMax, at: 0)
        }
        
        for i in 0..<height.count {
            let target = min(leftMaxArr[i], rightMaxArr[i]) - height[i]
            if target > 0 {
                result += target
            }
        }
        
        return result
    }
    
    /// 暴力法
    func trapBruteForce(_ height: [Int]) -> Int {
        var result = 0
        
        for i in 0..<height.count {
            var leftMax = 0
            var rightMax = 0
            for j in stride(from: i - 1, through: 0, by: -1) {
                leftMax = max(leftMax, height[j])
            }
            
            for j in stride(from: i + 1, to: height.count, by: 1) {
                rightMax = max(rightMax, height[j])
            }
            
            let target = min(leftMax, rightMax) - height[i]
            if target > 0  {
                result += target
            }
        }
        
        return result
    }
}

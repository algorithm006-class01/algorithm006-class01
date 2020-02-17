//
//  0011_ContainerWithMostWater.swift
//  AlgorithmPractice
//  
//  https://leetcode-cn.com/problems/container-with-most-water/
//  Created by Ryeagler on 2020/2/11.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation


class ContainerWithMostWater {
    // 暴力解法，这个解法在leetcode上超过了时间限制😂
    func maxAreaByBruteForce(_ height: [Int]) -> Int {
        var maxArea = 0
        for i in stride(from: 0, to: height.count, by: 1) {
            for j in stride(from: i + 1, to: height.count, by: 1) {
                let area = (j - i) * min(height[i], height[j])
                maxArea = max(maxArea, area)
            }
        }
        return maxArea
    }
    
    // 双指针解法
    func maxArea(_ height: [Int]) -> Int {
        if height.count <= 0 {
            return 0
        }
        var left = 0
        var right = height.count - 1
        
        var maxArea = 0
        while left < right {
            let area = (right - left) * (min(height[left], height[right]))
            maxArea = max(maxArea, area)
            if height[left] < height[right] {
                left += 1
            } else {
                right -= 1
            }
        }
        return maxArea
    }
}

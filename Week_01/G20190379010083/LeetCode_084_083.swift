//
//  0084-LargestRectangleInHistogram.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
//  Created by Ryeagler on 2020/2/15.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class LargestRectangleInHistogram {
    /// 暴力解法
    func largestRectangleAreaBruteForce(_ heights: [Int]) -> Int {
        var maxArea = 0
        for i in 0..<heights.count {
            var minHeight = Int.max
            for j in i..<heights.count {
                minHeight = min(minHeight, heights[j])
                maxArea = max(minHeight * (j - i + 1), maxArea)
            }
        }
        return maxArea
    }

    func largestRectangleArea(_ heights: [Int]) -> Int {
        return 0
    }
}

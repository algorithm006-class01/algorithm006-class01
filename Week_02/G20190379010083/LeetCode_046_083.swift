//
//  0046_ Permutations.swift
//  AlgorithmPractice
//
//  Created by Ryeagler on 2020/2/23.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class Permutations {
    func permute(_ nums: [Int]) -> [[Int]] {
        var result = [[Int]]()
        var tempArr = [Int]()
        backtrace(&result, &tempArr, nums)
        return result
    }

    func backtrace(_ result: inout [[Int]], _ tempArr: inout [Int], _ nums: [Int]) {
        if tempArr.count == nums.count  {
            result.append(tempArr)
        } else {
            for i in 0..<nums.count {
                if tempArr.contains(nums[i]) { continue }
                tempArr.append(nums[i])
                backtrace(&result, &tempArr, nums)
                tempArr.removeLast()
            }
        }
    }
}

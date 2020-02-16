//
//  0070_ClimbingStairs.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/climbing-stairs/
//  Created by Ryeagler on 2020/2/12.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class ClimbingStairs {
    // 递归法，递归的方式超出时间限制
    func climbStairsRecursion(_ n: Int) -> Int {
        if n <= 2 {
            return n
        }
        return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2)
    }
    
    func climbStairs(_ n: Int) -> Int {
        if n <= 2 {
            return n
        }
        var first = 1, second = 2, third = 3
        for _ in stride(from: 3, through: n, by: 1) {
            third = first + second
            first = second
            second = third
        }
        return third
    }
}

//
//  0191_NumberOf1Bits.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/number-of-1-bits/
//  Created by Ryeagler on 2020/3/12.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class NumberOf1Bits {
    func hammingWeight(_ n: Int) -> Int {
        var ones = 0, n = n
        while n != 0 {
            ones = ones + (n & 1)
            n = n >> 1
        }
        return ones
    }
    
    // n & n - 1会把最后一位1变成0
    func hammingWeight_1(_ n: Int) -> Int {
        var ones = 0, n = n
        while n != 0 {
            ones += 1
            n &= (n - 1);
        }
        return ones

    }
}

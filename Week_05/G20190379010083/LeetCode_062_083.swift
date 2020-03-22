//
//  0062_UniquePaths.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/unique-paths/
//  第一遍总结：
//      可以像uniquePaths ii那样创建一个m+1,n+1的数组，这样代码更简洁
//  Created by Ryeagler on 2020/3/15.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class UniquePaths {
    func uniquePaths(_ row: Int, _ column: Int) -> Int {
        var dp = [[Int]](repeating: [Int](repeating: 0, count: column), count: row)
        for i in 0..<column { dp[0][i] = 1 }
        for i in 0..<row { dp[i][0] = 1 }
        for r in 1..<row {
            for c in 1..<column {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1]
            }
        }
        return dp[row - 1][column - 1]
    }
    
    //MARK: 创建(m + 1) * (n + 1)的数组
    func uniquePaths_1(_ m: Int, _ n: Int) -> Int {
        var dp = [[Int]](repeating: [Int](repeating: 0, count: n + 1), count: m + 1)
        dp[0][1] = 1
        for i in 1...m {
            for j in 1...n {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[m][n]
    }
}

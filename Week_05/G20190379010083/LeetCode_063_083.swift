//
//  0063_UniquePathsII.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/unique-paths-ii/
//  第一遍总结：
//      1、创建一个m+1与n+1的数组，且dp[0][1] = 1
//      2、遇到障碍物0，则不进行动态递推
//  Created by Ryeagler on 2020/3/15.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class UniquePathsII {
    func uniquePathsWithObstacles(_ obstacleGrid: [[Int]]) -> Int {
        if obstacleGrid.count == 0 || obstacleGrid[0].count == 0 {
            return 0
        }
        let row = obstacleGrid.count, column = obstacleGrid[0].count
        var dp = [[Int]](repeating: [Int](repeating: 0, count: column + 1), count: row + 1)
        dp[0][1] = 1
        for i in 1...row {
            for j in 1...column {
                if obstacleGrid[i - 1][j - 1] == 0 {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                }
            }
        }
        return dp[row][column]
    }
}

//
//  0200_NumberOfIslands.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/number-of-islands/
//  第一遍总结：
//      1、经典DFS操作，没有什么好说的
//      2、BFS，相关题目:94 RottingOranges（腐烂的橘子）
//  Created by Ryeagler on 2020/3/16.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class NumberOfIslands {
    //MARK: DFS(递归）
    func numIslands(_ grid: [[Character]]) -> Int {
        var grid = grid, count = 0
        for i in 0..<grid.count {
            for j in 0..<grid[0].count {
                if grid[i][j] == "1" {
                    count += 1
                    dfs(&grid, i, j)
                }
            }
        }
        return 0
    }
    
    private func dfs(_ grid: inout [[Character]], _ i: Int, _ j: Int)  {
        if i >= 0 && i < grid.count && j >= 0 && j < grid[0].count && grid[i][j] == "1" {
            grid[i][j] = "0"
            dfs(&grid, i, i + 1)
            dfs(&grid, i, j - 1)
            dfs(&grid, i - 1, j)
            dfs(&grid, i + 1, j)
        }
    }
    
    //MARK: BFS
    func numIslands_BFS(_ grid: [[Character]]) -> Int {
        var grid = grid, count = 0
        var queue = Queue<(Int, Int)>()
        let directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        for i in 0..<grid.count {
            for j in 0..<grid[0].count {
                if grid[i][j] == "1" {
                    count += 1
                    queue.enqueue((i, j))
                    while !queue.isEmpty {
                        let (x, y) = queue.dequeue()!
                        for direction in directions {
                            let row = x + direction[0]
                            let column = y + direction[1]
                            if row >= 0 && row < grid.count && column >= 0 && column < grid[0].count && grid[row][column] == "1" {
                                grid[row][column] = "0"
                                queue.enqueue((row, column))
                            }
                        }
                    }
                }
            }
        }
        return count
    }

}

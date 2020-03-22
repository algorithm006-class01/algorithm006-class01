//
//  0022_GenerateParentheses.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/generate-parentheses/
//  Created by Ryeagler on 2020/2/26.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class GenerateParentheses {
    //MARK: Backtrace
    func generateParentheses(_ n: Int) -> [String] {
        var combinations = [String]()
        backtrace(&combinations, String(), 0, 0, n)
        return combinations
    }
    
    private func backtrace(_ result: inout [String], _ current: String, _ open: Int, _ close: Int, _ max: Int) {
        if current.count == 2 * max {
            result.append(current)
            return
        }
        if open < max {
            backtrace(&result, current + "(", open + 1, close, max)
        }
        if close < open {
            backtrace(&result, current + ")", open, close + 1, max)
        }
    }
    
    //MARK: Brute Force
    func generate(_ n: Int) -> [String] {
        var combinations = [String]()
        var current = [Character](repeating: " ", count: 2 * n)
        generateAll(&current, 0, &combinations)
        return combinations
    }
    
    private func generateAll(_ current: inout [Character], _ position: Int, _ result: inout [String]) {
        if position == current.count {
            if valid(current) {
                result.append(String(current))
            }
        } else {
            current[position] = "("
            generateAll(&current, position + 1, &result)
            current[position] = ")"
            generateAll(&current, position + 1, &result)
        }
    }
    
    func valid(_ current: [Character]) -> Bool {
        var balance = 0
        for c in current {
            if c == "(" {
                balance += 1
            } else {
                balance -= 1
            }
            if balance < 0 {
                return false
            }
        }
        return balance == 0
    }
}


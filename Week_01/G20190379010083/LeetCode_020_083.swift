//
//  0020_ValidParentheses.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/valid-parentheses/
//  Created by Ryeagler on 2020/2/15.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class ValidParentheses {
    func isValid(_ s: String) -> Bool {
        let map: [Character: Character] = ["[": "]", "(": ")", "{": "}"]
        var stack: Stack<Character> = Stack<Character>()
        for character in s {
            if map[character] != nil {
                stack.push(character)
            } else {
                if  let top = stack.pop() {
                    if map[top] != character {
                        return false
                    }
                } else {
                    return false
                }
            }
        }
        return stack.isEmpty
    }
}

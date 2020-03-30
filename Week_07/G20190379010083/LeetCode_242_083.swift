//
//  0242_ValidAnagram.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/valid-anagram/
//  Created by Ryeagler on 2020/2/18.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class ValidAnagram {
    func isAnagramSort(_ s: String, _ t: String) -> Bool {
        let sortedS = s.sorted()
        let sortedT = t.sorted()
        return sortedT == sortedS
    }
    
    func isAnagram(_ s: String, _ t: String) -> Bool {
        if s.count != t.count {
            return false
        }
        var dict = [Character: Int]()
        for char in s {
            if let count = dict[char] {
                dict[char] = count + 1
            } else {
                dict[char] = 1
            }
        }
        
        for char in t {
            if dict[char] == nil {
                return false
            } else if dict[char]! == 0 {
                return false
            }

            dict[char] = dict[char]! - 1
        }
        return true
    }
    
}

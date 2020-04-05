//
//  0005_LongestPalindromicSubstring.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/longest-palindromic-substring/
//  第一遍总结：
//      这道题知道了怎么做就很简单，取一个或两个字母左右扩散。在整个过程中记录满足回文条件的最长长度
//  Created by Ryeagler on 2020/3/16.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class LongestPalindromicSubstring {
    func longestPalindrome(_ s: String) -> String {
        if s.count <= 1 {
            return s
        }
        let array = s.map{ $0 }
        var left = 0, count = 0
        for i in 0..<array.count - 1 {
            (left, count) = expend(array, i, i, left, count)
            (left, count) = expend(array, i, i + 1, left, count)
        }
        var result = ""
        while count > 0 {
            result = result + String(array[left])
            left += 1
            count -= 1
        }
        return result
    }

    private func expend(_ array: [Character], _ i: Int, _ j: Int, _ left: Int, _ count: Int) -> (Int, Int) {
        var i = i, j = j
        while i >= 0 && j < array.count && array[i] == array[j] {
            i -= 1
            j += 1
        }
        if j - i - 1 > count {
            return (i + 1, j - i - 1)
        }
        return (left, count)
    }
}

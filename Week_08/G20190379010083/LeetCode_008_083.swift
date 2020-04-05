//
//  0008_Atoi.swift
//  AlgorithmPractice
//
//  https://leetcode-cn.com/problems/string-to-integer-atoi/
//  第一遍刷题的问题：
//      #1、while循环判断错误写成index < array.count, 应为index < array.count - 1
//      #2、while循环的index没有增加
//      #3、判断完正负之后，发现不满足数字直接break最好
//  第3遍刷题总结：
//      1、去空格
//      2、判断正负或者非法字符
//      3、循环，遇到非法字符break
//      4、result应该使用Double，不然会溢出（不过最好在result累积的过程中判断）
//  Created by Ryeagler on 2020/3/3.
//  Copyright © 2020 Ryeagle. All rights reserved.
//

import Foundation

class MyAtoi {
    func myAtoi(_ str: String) -> Int {
        let charArray: [Character] = str.map{$0}
        var index = 0
        for char in charArray {
            if char == " " {
                index += 1
            } else {
                break
            }
        }
        
        var isNegative = false
        if index < charArray.count - 1 {
            if charArray[index] == "+" {
                index += 1
            } else if charArray[index] == "-" {
                index += 1
                isNegative = true
            }
        }
        
        var result: Double = 0
        // 1、index < charArray.count - 1
        while index < charArray.count {
            if !"0123456789".contains(charArray[index])  {
                // 3、这break更好
                break
//                // 2、直接返回result，未考虑为负数的情况
//                return check(isNegative, result: &result)
            }
            
            result *= 10
            result += Double(String(charArray[index]))!
            // 3、下标未更新
            index += 1
        }
        
        if isNegative {
            result = -result
        }
        // 这里转成Double，是防止移除报错
        if result > Double(Int32.max) {
            return Int(Int32.max)
        } else if result < Double(Int32.min) {
            return Int(Int32.min)
        }
        return Int(result)
    }

    
    func myAtoi_1(_ str: String) -> Int {
        var numArray = [Int]()
        var isNegative = false
        var seenSign = false
        for c in str {
            if c == " " && numArray.count == 0  && !seenSign {
                continue
            } else if (c == "+" || c == "-") && numArray.count == 0 && !seenSign {
                isNegative = c == "-"
                seenSign = true
            } else if "0123456789".contains(c) {
                numArray.append(Int(String(c))!)
            } else {
                break
            }
        }
        if numArray.count == 0 {
            return 0
        }

        var result = 0.0
        for num in numArray {
            result = result * 10 + Double(num)
        }
        if isNegative {
            result = -result
        }

        if result > Double(Int32.max) {
            return Int(Int32.max)
        } else if result < Double(Int32.min) {
            return Int(Int32.min)
        }

        return Int(result)
    }

}

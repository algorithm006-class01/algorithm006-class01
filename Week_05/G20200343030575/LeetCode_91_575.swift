/*
 * @lc app=leetcode.cn id=91 lang=swift
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    
    enum CombineResult{
        case notValid
        case sameAsLast         //和上一个相同
        case sameAsLastSecond   //和倒数第二个相同
        case sumOfPrevios   // f(n) = f(n-1)+f(n-2)
    }
    
    func numDecodings(_ s: String) -> Int {
        guard let first = s.first, first != "0" else {
            return 0
        }
        
        var results = Array<Int>.init(repeating: 0, count: s.count + 1)
        results[0] = 1
        results[1] = 1
        for i in 1..<s.count {
            let currentChar = s[s.index(s.startIndex, offsetBy: i)]
            let lastChar = s[s.index(s.startIndex, offsetBy: i-1)]
            
            switch combineResult(first: lastChar, second: currentChar) {
            case .notValid:
                return 0
            case .sameAsLast:
                results[i+1] = results[i]
            case .sameAsLastSecond:
                results[i+1] = results[i-1]
            case .sumOfPrevios:
                results[i+1] = results[i] + results[i-1]
            }
        }
        
        return results.last!
        
    }
    
    func combineResult(first: Character, second: Character) -> CombineResult{
        if second == "0" {
            if first == "1" || first == "2" {
                return .sameAsLastSecond
            }else{
                return .notValid
            }
        }else{
            if first == "1"  || (first == "2" && second >= "1" && second <= "6") {
                return .sumOfPrevios
            }else{
                return .sameAsLast
            }
        }
    }
}
// @lc code=end


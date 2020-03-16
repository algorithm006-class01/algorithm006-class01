/*
 * @lc app=leetcode.cn id=860 lang=swift
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    func lemonadeChange(_ bills: [Int]) -> Bool {
        guard bills.count > 0 else {
            return true
        }
        
        var fiveDollarCount = 0, tenDollarCount = 0;
        for bill in bills {
            if bill == 5 {
                fiveDollarCount += 1
            }else if bill == 10 {
                fiveDollarCount -= 1
                tenDollarCount += 1
            }else if bill == 20 {
                if tenDollarCount > 0 {
                    tenDollarCount -= 1
                    fiveDollarCount -= 1
                }else{
                    fiveDollarCount -= 3
                }
            }
            
            if fiveDollarCount < 0 || tenDollarCount < 0 {
                return false
            }
        }
        return true
    }
}

// @lc code=end


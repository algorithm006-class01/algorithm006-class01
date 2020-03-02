#
# @lc app=leetcode.cn id=860 lang=python
#
# [860] 柠檬水找零
#
# 解题思路
# 1.贪心算法
#   1.每次只找最优解，就是有5直接收
#   2.10的情况找5，如果5没有就找零失败
#   3.如果大于10，没有10和5的情况，找零失败
#   如果没有10，有3个5也可以，否则找零失败
# @lc code=start
class Solution(object): 
    def lemonadeChange(self, bills):
        five = ten = 0
        for bill in bills:
            if bill == 5:
                five += 1
            elif bill == 10:
                if not five: return False
                five -= 1
                ten += 1
            else:
                if ten and five:
                    ten -= 1
                    five -= 1
                elif five >= 3:
                    five -= 3
                else:
                    return False
        return True

        
        

        
        
        
# @lc code=end


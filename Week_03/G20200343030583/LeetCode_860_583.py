#
# @lc app=leetcode id=860 lang=python
#
# [860] Lemonade Change
# special solution:
# calculate the needs of five
# we need $5 for one $10 and three $5 for $20, 
# However, if we have many $10, then we can save two $5
# the number of $5 saved is min(count of $20, count of $10)
# Because if count($20) > count($10), we can just save 2*count($10) 
# if count($10) > count($20), we have enough $ 10 and just need to consider the $20 cases
#https://leetcode.com/problems/lemonade-change/discuss/392612/Very-simple-O(n)-Python-solution

# @lc code=start
# too slow
class Solution(object):
    def lemonadeChange(self, bills):
        """
        :type bills: List[int]
        :rtype: bool
        """
        if bills[0] > 5:
            return False
        # because you have not change in hand, so the first bill should be 5
        self.bills_count = {5:1,10:0,20:0}
        return self.provide_change(1,bills)

    def provide_change(self,index,bills):
        if index == len(bills):
            return True
        result = False
        if bills[index] - 5 == 0:
            self.bills_count[5] += 1
            # print("receive $5")
            result = self.provide_change(index + 1, bills)
            self.bills_count[5] -= 1
            return result

        if bills[index] - 5 == 5:
            if self.bills_count[5] != 0:
                self.bills_count[10] += 1
                self.bills_count[5] -= 1
                # print("receive $10")
                result = self.provide_change(index + 1, bills)
                self.bills_count[10] -= 1
                self.bills_count[5] += 1
                return result
                
            else:
                return result
        if bills[index] - 5 == 15: 
            # two ways to provide change
            i = 2
            WAY_ONE = False
            WAY_TWO = False
            while(i > 0):
                if self.bills_count[5] >= 1 and self.bills_count[10] != 0 and not WAY_TWO:
                    self.bills_count[20] += 1
                    self.bills_count[5] -= 1
                    self.bills_count[10] -= 1
                    WAY_TWO = True
                    # print("receive $20, change with one $5 and one $10")
                    result = self.provide_change(index + 1, bills)
                     # reset status
                    self.bills_count[20] -= 1
                    self.bills_count[5] += 1
                    self.bills_count[10] += 1
                    if result:
                        return result
                elif self.bills_count[5] >= 3 and not WAY_ONE:
                    self.bills_count[20] += 1
                    self.bills_count[5] -= 3
                    WAY_ONE = True
                    # print("receive $20, change with three $5")
                    result = self.provide_change(index + 1, bills)
                    # reset status
                    self.bills_count[20] -= 1
                    self.bills_count[5] += 3
                    if result:
                        return result
                else:
                    WAY_ONE = False
                    WAY_TWO = False
                    return False
                i -= 1
            WAY_ONE = False
            WAY_TWO = False
            return result

# official solution
class Solution(object): 
    def lemonadeChange(self, bills):
        five, ten = 0, 0
        for bill in bills:
            if bill == 5:
                five += 1
            elif bill == 10:
                if five > 0:
                    five -= 1
                    ten += 1
                else:
                    return False
            else:
                if ten > 0 and five > 0:
                    five -= 1
                    ten -= 1
                elif five >= 3:
                    five -= 3
                else:
                    return False
        
        return True

# special solution
class Solution(object): 
    def lemonadeChange(self, bills):
        bill_counts = {5:0,10:0,20:0}
        for bill in bills:
            bill_counts[bill] += 1
            if bill_counts[5] < (bill_counts[10] + 3 * bill_counts[20] - 2 * min(bill_counts[20],bill_counts[10])):
                return False
                
        return True
# @lc code=end


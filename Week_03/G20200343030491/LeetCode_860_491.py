class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:

        dic = {
            '5'  : 0,
            '10' : 0,
        }    
            
        for i in bills:
            if i==5:
                dic['5'] += 1
            if i==10:
                dic['10'] += 1
                dic['5'] -= 1
                if dic['5'] < 0:
                    return False
            if i==20:
                if dic['10'] >= 1:
                    dic['10'] -= 1
                    dic['5'] -=1
                else:
                    dic['5'] -= 3
                if dic['5'] < 0:
                    return False

        return True


class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        
        five, ten = 0, 0
        
        for i in bills:
            if i==5: five += 1
            elif i==10:
                five -= 1 
                ten += 1
            else:
                if ten>0:
                    ten -= 1
                    five -= 1
                else:
                    five -= 3
                    
            if five < 0: return False
            
        return True
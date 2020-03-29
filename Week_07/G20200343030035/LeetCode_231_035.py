'''
231. 2的幂
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

'''

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n == 1:
            return True
        while n > 0:
            if (n / 2) == 1:
                return True
            elif (n % 2) == 0:
                n = n // 2 
            else:
                return False
        return False
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n != 0 and (n & (n-1)) == 0

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n<=0: return False
        if n == 1:
            return True
        if n%2==0:
            return self.isPowerOfTwo(n>>1)

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n<=0: return False
        def rec(n):
            if n==1:
                return True
            if n%2 == 1:
                return False
            return rec(n>>1)
        
        return rec(n)

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n<=0:
            return False
        while n != 1:
            if n%2 == 1: 
                return False
            n = n>>1
        return True
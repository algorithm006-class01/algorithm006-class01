class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        for i in range(32):
            if ((n>>i) & 1) == 1:
                count += 1
                
        return count

class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        while n !=0:
            if n&1 == 1:
                count += 1
            n = n>>1
            
        return count


class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        while n !=0:
            if n%2 == 1:
                count += 1
            n = n>>1
            
        return count

class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        while n !=0:
            if n%2 == 1:
                count += 1
            n = n//2
            
        return count

class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        while n != 0:
            count += 1
            n = n & (n-1)           
        return count
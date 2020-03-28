class Solution:
    def reverseBits(self, n: int) -> int:
        res = n & 1
        for _ in range(31):
            res = res << 1
            n = n >> 1
            res |= (n & 1)
            
        return res

class Solution:
    def reverseBits(self, n: int) -> int:
        res, mask = 0, 1
        for i in range(32):
            if n & mask: 
                res = res | (1<<(31-i))
            mask = mask << 1
            
        return res

class Solution:
    def reverseBits(self, n: int) -> int:
        for i in range(16):
            x = (n>>i) & 1
            y = (n>>(31-i)) & 1
            
            if x == 0:
                n = n & (~(1<<(31-i)))
            if x == 1:
                n = n | (1<<(31-i))
                
            if y == 0:
                n = n & (~(1<<(i)))
                
            if y == 1:
                n = n | (1<<(i))
                
                
        return n
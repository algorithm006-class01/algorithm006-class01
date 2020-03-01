class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        a = [i+1 for i in range(n)]
        
        def rec(arr, k):
            res = []
            if k==0:
                return [[]]
            for i in range(len(arr)-k+1):
                for mid in rec(arr[i+1:], k-1):
                    res.append([arr[i]]+mid)
            return res
        
        return rec(a,k)


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        if k == 0:
            return [[]]
        for i in range(k,n+1):
            for temp in self.combine(i-1,k-1):
                res.append(temp+[i])
                
        return res
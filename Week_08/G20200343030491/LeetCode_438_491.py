class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        n, i = len(p), 0
        res = []
        PC = Counter(p)
        SC = Counter(s[:n-1])
        
        while i+n<=len(s):
            SC[s[i+n-1]] += 1
            if PC == SC:
                res.append(i)
            SC[s[i]] -= 1
            if SC[s[i]] == 0:
                del SC[s[i]]
            i+=1
            
        return res
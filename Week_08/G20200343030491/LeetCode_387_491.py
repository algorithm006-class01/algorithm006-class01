class Solution:
    def firstUniqChar(self, s: str) -> int:
        dic = Counter(s)
        for i in dic:
            if dic[i]==1:
                return s.index(i)
        return -1 

class Solution:
    def firstUniqChar(self, s: str) -> int:
        dic = Counter(s)
        for idx, c in enumerate(s):
            if dic[c] == 1:
                return idx
        return -1
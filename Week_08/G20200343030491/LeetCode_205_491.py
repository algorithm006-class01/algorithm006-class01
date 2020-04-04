class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        dicS, dicT = {}, {}
        for i, v in enumerate(s):
            dicS.setdefault(v,[])
            dicS[v].append(i)
        for i, v in enumerate(t):
            dicT.setdefault(v,[])
            dicT[v].append(i)
        return list(dicS.values())==list(dicT.values())


class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        return len(set(zip(s,t)))==len(set(s))==len(set(t))
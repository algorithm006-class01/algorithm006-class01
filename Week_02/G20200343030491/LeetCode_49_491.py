class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dic = {}
        for s in strs:
            if str(sorted(s)) in dic:
                dic[str(sorted(s))].append(s)
            else:
                dic[str(sorted(s))] = [s]
        return dic.values()
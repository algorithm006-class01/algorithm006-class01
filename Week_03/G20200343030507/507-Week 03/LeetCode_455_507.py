from typing import List

class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        # 对g和s升序排序，s是饼干，g是胃口
        g.sort()
        s.sort()
        res = 0
        i = 0
        for e in s:
            if i == len(g):
                break
            # 可以满足胃口，把小饼干喂给小朋友，否则看下一块饼干
            if e >= g[i]:
                res += 1
                i += 1
        return res
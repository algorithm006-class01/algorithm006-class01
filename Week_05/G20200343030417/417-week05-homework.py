# 青蛙过河
class Solution:
    def canCross(self, stones):
        dp = dict()

        for s in stones:
            dp.setdefault(s,set())
        
        dp.get(0).add(0)

        for s in stones:
            for pre_step in dp.get(s):
                for step in [pre_step-1,pre_step,pre_step+1]:
                    if step > 0 and (s+step) in dp:
                        dp.get(s+step).add(step)
        return len(dp.get(stones[-1])) > 0





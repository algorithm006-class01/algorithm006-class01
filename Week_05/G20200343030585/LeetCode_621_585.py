#
# @lc app=leetcode.cn id=621 lang=python
#
# [621] 任务调度器
# 官方解答
# https://leetcode-cn.com/problems/task-scheduler/solution/ren-wu-diao-du-qi-by-leetcode/

# 1.动态规划
#   直接看解答
# 
# @lc code=start
class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        
        map = [0] * 26
        for c in tasks:
            map[ord(c) - ord('A')] += 1
            
        map.sort()
        max_val = map[25] - 1 # 间隔运行次数
        idle_slots = max_val * n # 总间隔时间
        for i in range(24, -1, -1):
            if map[i] == 0:
                continue
            idle_slots -= min(map[i], max_val)
            
        return idle_slots + len(tasks) if idle_slots > 0 else len(tasks)
        
# @lc code=end


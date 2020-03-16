# 55.跳跃游戏
# 贪心算法完成跳跃游戏
class Solution(object):
    def canJump(self,nums):
        max_i = 0  # 初始化当然爱安能到达的最远的位置
        for i,jump in enumerate(nums):  # i为当前位置，jump是当前未知的跳数
            if max_i >= i and i+jump > max_i:  #如果当前位置能够到达，并且当前位置+跳数>最远距离
                max_i = i+jump  # 更新最远能够到达的位置
        
        return max_i >= i
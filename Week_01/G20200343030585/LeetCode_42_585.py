# -*- coding:utf-8 -*-
# 解题思路：
# 1 什么是能接水的空间，是一个柱子后有个下降的空间，等于是后面柱子的高度小于当前柱子的高度，同时后面还要有个上升空间
# 2 知道了接水的空间后再计算接水的大小，1宽度*1高度为一个单位，下降的空间会有占用空间的柱子，要把这个删除
# 3 使用一个栈和两个指针，第一个指针指向第一个元素，第二个指针依次指向第一个指针后面的元素
# 4 发现一个柱子比栈顶小就入栈，比栈顶高栈顶元素出栈，出栈后再计算与新的栈顶之间的水，
#  min(height[current], height[st[top]]) * (current - st[top] - 1)
# 可以将两边中一边最高的元素作为水池的高，减去中间任意大于0的柱子 heights[i]，
# 


class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) < 3:
            return 0
        
        sum = 0 # 总蓄水量
        current = 0 # 当前指针
        st = [] # stack 
        

        for current in range(0, len(height)):
            # 如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while len(st) > 0 and height[current] > height[st[0]]:
                h = height[st[0]]; # 取出要出栈的元素
                st.pop(0); #出栈
                if (len(st) == 0):   # 栈空就出去
                    break; 
                
                distance = current - st[0] - 1  #两堵墙之前的距离。
                minVal = min(height[st[0]], height[current])
                sum = sum + distance * (minVal - h)
            
            st.insert(0, current) # 当前指向的墙入栈
            current += 1 # 指针后移
                    
        return sum

if __name__ == "__main__":
    obj = Solution()               
    # print(obj.trap([0,1,0,2,0,1,0,1,3,2,1,2,1]))
    # print(obj.trap([1,2,3,4,0,5]))    
    # print(obj.trap([2,0,2]))
    print(obj.trap([9,2,9,3,2,2,1,4,8]))
        
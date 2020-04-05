#
# @lc app=leetcode.cn id=8 lang=python
#
# [8] 字符串转换整数 (atoi)
#
# 解题思路（参考如下地址）
# 1.将字符串的空白去掉，然后使用正则表达式解析字符串
# 2.max和min是用来防止结果越界，因为题设只要求32位大小的有符号整数

# https://leetcode-cn.com/problems/string-to-integer-atoi/solution/python-1xing-zheng-ze-biao-da-shi-by-knifezhu/
# @lc code=start
import re

class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        return max(min(int(*re.findall('^[\+\-]?\d+', str.lstrip())), 2**31 - 1), -2**31)    
# @lc code=end


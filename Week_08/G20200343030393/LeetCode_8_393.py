import re

class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        INT_MAX = 2147483647
        INT_MIN = -2147483648
        str = str.lstrip()
        num_re = re.compile(r'^[\+\-]?\d+')
        num = num_re.findall(str)
        num = int(*num)
        return max(min(num, INT_MAX), INT_MIN)
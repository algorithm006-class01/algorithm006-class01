"""
    请你来实现一个 atoi 函数，使其能将字符串转换成整数。

    首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

    当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
    假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

    该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

    注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

    在任何情况下，若函数不能进行有效的转换时，请返回 0。

    说明：

        假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1] 。
"""


class Solution:
    def myAtoi(self, str: str) -> int:
        str_len = len(str)

        # 过滤掉前面的空格
        index = 0
        while index < str_len:
            if str[index] != ' ':
                break
            else:
                index += 1

        if index == str_len:
            return 0

        # 判断正负
        flag = 1
        if str[index] == "+":
            index += 1
        elif str[index] == "-":
            index += 1
            flag = -1

        # 开始取值
        res = 0
        while index < str_len:
            char = str[index]
            index += 1
            if char > "9" or char < "0":
                break

            res = res * 10 + flag * (int(char) - 0)

            if res < -2147483648:
                return -2147483648
            if res > 2147483647:
                return 2147483647
        return res


if __name__ == '__main__':
    print(Solution().myAtoi("   -42"))

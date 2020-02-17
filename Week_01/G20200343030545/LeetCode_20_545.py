"""
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。

    示例 1:
        输入: "()"
        输出: true

    示例 2:
        输入: "()[]{}"
            输出: true

    示例 3:
        输入: "(]"
        输出: false

    示例 4:
        输入: "([)]"
        输出: false

    示例 5:
        输入: "{[]}"
        输出: true
"""


class Solution:
    def isValid(self, s: str) -> bool:
        return self.use_stack(s)

    @classmethod
    def use_stack(cls, s: str) -> bool:
        """
            运用栈这种数据结构
            依次遍历字符串入栈。
            当字符属于右括号时，弹出站定元素，比较弹出的内容和此时遍历的内容。如果有效循环这个操作，如果无效则直接返回非False
            当字符属于左括号时，压栈。
            循环结束判断栈里是否还有元素，如果有则返回False， 无返回True

            有一个小技巧：就是可以先判断字符串的长度，如果长度是奇数，则肯定不是有效的。
            时间复杂度O(n)，空间复杂度O(n)
        """

        s_len = len(s)

        if s_len % 2 != 0:  # 奇数为肯定不符合要求
            return False

        stack = []
        for info in s:
            if info in ("]", "}", ")"):
                if not stack:
                    return False
                ori_info = stack.pop()
                if cls.check_valid(ori_info, info):
                    continue
                else:
                    return False
            else:
                stack.append(info)
        return True if not stack else False

    @classmethod
    def check_valid(cls, info: str, check_info: str) -> bool:
        if info == "[" and check_info == "]":
            res = True
        elif info == "{" and check_info == "}":
            res = True
        elif info == "(" and check_info == ")":
            res = True
        else:
            res = False

        return res


if __name__ == '__main__':
    print(Solution.use_stack("(]"))

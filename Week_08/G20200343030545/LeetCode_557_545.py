"""
    给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
    示例 1:
        输入: "Let's take LeetCode contest"
        输出: "s'teL ekat edoCteeL tsetnoc" 

    注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
"""


class Solution:
    def reverseWords(self, s: str) -> str:
        s_list = list(s)
        start_index = 0
        end_index = len(s_list) - 1

        tmp_start_index = 0

        while start_index <= end_index:
            if s_list[start_index] == " ":
                # 反转之前的数据
                self.swap(tmp_start_index, start_index - 1, s_list)

                # 过滤掉多余的空格
                while s_list[start_index] == " ":
                    start_index += 1
                tmp_start_index = start_index

            start_index += 1

        self.swap(tmp_start_index, len(s_list) - 1, s_list)
        return ''.join(s_list)

    @classmethod
    def swap(cls, i, j, params):
        while i <= j:
            params[i], params[j] = params[j], params[i]
            i += 1
            j -= 1


if __name__ == '__main__':
    print(Solution().reverseWords("Let's take LeetCode contest"))

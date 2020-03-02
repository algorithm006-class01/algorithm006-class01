class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        # execution time: 12 ms; memory consumption: 11.7MB
        phone = {'2': ['a', 'b', 'c'],
                 '3': ['d', 'e', 'f'],
                 '4': ['g', 'h', 'i'],
                 '5': ['j', 'k', 'l'],
                 '6': ['m', 'n', 'o'],
                 '7': ['p', 'q', 'r', 's'],
                 '8': ['t', 'u', 'v'],
                 '9': ['w', 'x', 'y', 'z']}

        def __combination(string_combination, next_digits):
            if len(next_digits) == 0:
                return result.append(string_combination)
            else:
                for i in phone[next_digits[0]]:
                    __combination(string_combination+i, next_digits[1:])

        result = []
        if digits:
            __combination("", digits)
        return result

        # execution time: 28 ms; memory consumption: 11.6MB
        # dict = {'2': "abc", '3': "def", '4': "ghi", '5': "jkl", '6': "mno", '7': "pqrs",
        #         '8': "tuv", '9': "wxyz"}
        # cmb = [''] if digits else []
        # for d in digits:
        #     cmb = [p + q for p in cmb for q in dict[d]]
        # return cmb

        # execution time: 24 ms; memory consumption: 11.6MB
        # mapping = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl',
        #            '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        # if len(digits) == 0:
        #     return []
        # if len(digits) == 1:
        #     return list(mapping[digits[0]])
        # prev = self.letterCombinations(digits[:-1])
        # additional = mapping[digits[-1]]
        # return [s + c for s in prev for c in additional]


digits = "234"
aa = Solution()
print(aa.letterCombinations(digits))
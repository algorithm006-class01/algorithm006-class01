class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        n = len(nums)

        def helper(i, tmp):
            res.append(tmp)
            for j in range(i, n):
                helper(j + 1, tmp + [nums[j]])

        helper(0, [])
        return res

        # res = [[]]
        # for i in nums:
        #     res += [[i] + num for num in res]
        # return res


nums = [1, 2, 3]
aa = Solution()
print(aa.subsets(nums))
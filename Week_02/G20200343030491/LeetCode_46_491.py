class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if len(nums)==0:
            return [[]]
        return [[nums[i]]+temp for i in range(len(nums)) for temp in self.permute(nums[:i]+nums[i+1:])]

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        perms = [[]]
        for num in nums:
            temp_p = []
            for perm in perms:
                for i in range(len(perm)+1):
                    temp_p.append((perm[:i] + [num] + perm[i:]))
            perms=temp_p
        return perms

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def backtrack(nums, temp):
            if not nums:
                res.append(temp)
                return
            for i in range(len(nums)):
                backtrack(nums[:i]+nums[i+1:],temp+[nums[i]])
        backtrack(nums,[])
        return res
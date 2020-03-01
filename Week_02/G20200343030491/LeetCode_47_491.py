class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        
        if len(nums)==0:
            return [[]]
        
        for i in range(len(nums)):
            for temp in self.permuteUnique(nums[:i]+nums[i+1:]):
                if [nums[i]] + temp not in res:
                    res.append([nums[i]] + temp)
                    
        return res


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        perms = [[]]
        for num in nums:
            temp = []
            for perm in perms:
                for i in range(len(perm)+1):
                    temp.append(perm[:i]+[num]+perm[i:])
                    if i<len(perm) and perm[i]==num: break
            perms = temp
            
        return perms
class Solution:
    def __init__(self):
        self.cnt = 0
    def mergeSort(self,nums,begin,end):
        if begin>=end: return
        mid = (begin+end)//2
        self.mergeSort(nums,begin,mid)
        self.mergeSort(nums,mid+1,end)
        self.merge(nums,begin,mid,end)
    def merge(self,nums,begin,mid,end):
        #
        j = mid + 1
        count = 0
        i = begin
        while i<=mid:
            if j<=end and nums[i]>2*nums[j]:
                j += 1
                count +=1
            else:
                i += 1
                self.cnt += count
        #
        nums[begin:end+1] = sorted(nums[begin:end+1])
        
    def reversePairs(self, nums: List[int]) -> int:
        self.mergeSort(nums,0,len(nums)-1)
        return self.cnt
class Solution:
    def binarySearch(self,arr,n):
        if not arr:
            return [n]
        left, right = 0, len(arr)-1
        while left<=right:
            mid = (right+left)>>1
            
            if n < arr[mid]:
                right = mid - 1
            else:
                left = mid + 1
                
        return arr[:right+1] + [n] + arr[right+1:]
    
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        dict2 = {}
        arr_last = []
        arr_first = []
        for i in arr2:
            dict2[i] = []
        for i in arr1:
            if i in dict2:
                dict2[i] += [i]
                continue
            arr_last = self.binarySearch(arr_last,i)
            
        for i in dict2:
            arr_first += dict2[i]
            
        return arr_first + arr_last

class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        if not arr1:
            return []
        if not arr2:
            return sorted(arr1)
        res, temp= [], []
        dict2 = OrderedDict.fromkeys(arr2,0)
        used = set()
        for i in arr1:
            if i in dict2:
                dict2[i] += 1
                used.add(i)
        for k, v in dict2.items():
            for _ in range(v):
                res.append(k)
        for i in arr1:
            if i not in used:
                temp.append(i)
        if temp:
            return res+sorted(temp) 
        else:
            return res
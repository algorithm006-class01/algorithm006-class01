'''
https://leetcode.com/problems/two-sum/

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

'''

# 思路1
'''
暴力法


遍歷所有數組
外層loop i:n-1
    內層loop 從 i+1:n
        由於假設每種輸入只會對應一組答案，所以
        找到相加等於目標數字立即返回(i,j)

time complexity: O(n^2)
leetcode result:
Accepted	5988 ms	13.7 MB
'''


class Solution1:
    def twoSum(self, nums, target: int):
        n = len(nums)
        for i in range(n - 1):
            for j in range(i + 1, n):
                if nums[i] + nums[j] == target:
                    return [i, j]


'''
思路2：
先將裡面的元素由小到大做排序，時間複雜度為logN
再用左右夾逼的方式移動元素
若兩元素相加> target 
則把最右邊的j 往左移
若兩元素相加< target
則把最左的元素向右移
直到兩指針相交 (i==j)

time complexity: O(N)  

leetcode result:
Runtime: 52 ms, faster than 56.49% of Python3 online submissions for Two Sum.
Memory Usage: 14 MB, less than 65.58% of Python3 online submissions for Two Sum.
'''


class Solution2:
    def twoSum(self, nums, target: int):
        orignal_list = nums.copy()
        n = len(nums)
        nums.sort()
        i = 0
        j = n - 1
        while True:
            if (nums[i] + nums[j] > target):
                j = j - 1
            elif (nums[i] + nums[j] < target):
                i = i + 1
            else:
                break;
        return self._find_index(orignal_list, nums[i], nums[j])

    def _find_index(self, input_list, a, b):
        index_a = input_list.index(a)
        index_b = input_list.index(b)
        # 去重
        if index_a == index_b:
            [index_a, index_b] = [i for i, x in enumerate(input_list) if x == a]
        return [index_a, index_b]


'''
解法3 空間換時間(字典)
這邊哈希表我還不太熟，待以後來補全解法
目前先用空間換時間的做法來試試

想法為用字典來儲存target - list 中的每一個元素
如果之後遇到list 中的新元素存在於字典中，表示這個新元素與之前的結果是相匹配的
===========
一開始先檢查字典中是否有當前list中的元素

若有 則返回字典的key 值與當前list的位址 (表示湊到一對)
若無 則將目前list的位址與減完的結果一併存於字典中，以利後續查找

此法只比前面快了一點點(4ms) 、時間複雜度應為 O(N)
多用了0.2mb 的ram
但這取決於array 的大小
不過代碼是簡潔了很多

Runtime: 48 ms, faster than 79.16% of Python3 online submissions for Two Sum.
Memory Usage: 14.2 MB, less than 56.04% of Python3 online submissions for Two Sum.

'''


class Solution3:
    def twoSum(self, nums, target: int):
        temp_dict = {}
        for key, item in enumerate(nums):
            check_result = target - item
            if item in temp_dict:
                return [temp_dict[item], key]
            else:
                temp_dict[check_result] = key




if __name__ == "__main__":
    # k=[4,5,1,3,2]
    # k.sort()
    # print(k)3
    s1 = Solution3().twoSum([4, 3, 3], 6)
    print(s1)

# 解题思路
# 1、使用hashmap 将每个词排序后和索引一起放到hashmap，然后循环查询单词
# 2、生成每个词的有序数组，然后比较每个数组是否一样，一样的放一起，要保留一个数组和原数组对应关系
# 3、将字符串数组的每个字母单独计算出现次数，每个字母按字母顺序排列，然后以此为key，字符串的list集合为值

class Solution(object):
    def groupAnagrams(self, strs):
        ans = collections.defaultdict(list)
        for s in strs:
            ans[tuple(sorted(s))].append(s)
        return ans.values()

#  效率太低执行不通过
# class Solution(object):
#     def groupAnagrams(self, strs):
#         length = len(strs)
#         arr = []
#         for i in range(length):
#             arr.append(sorted(strs[i]))
        
#         _ret, ret = [], []
        
#         for i in range(length):
#             if arr[i] == '---':
#                 continue
#             _ret.append(strs[i])
#             for j in range(i+1, length):
#                 if arr[j] == '---':
#                     continue
#                 if arr[j] == arr[i] and arr[j] != '---':
#                     _ret.append(strs[j])
#                     arr[j] = '---'
#             ret.append(_ret)
#             _ret = []
#         return ret


# 
class Solution(object):
    def groupAnagrams(self, strs):
        ans = collections.defaultdict(list)
        for s in strs:
            count = [0] * 26 #一个python简化的语句，很方便
            for c in s:
                count[ord[c] - ord['a']] += 1
            ans[tuple(count)].append(s)
        return ans.values()
                
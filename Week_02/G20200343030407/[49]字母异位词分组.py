# 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
# 
#  示例: 
# 
#  输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
# 输出:
# [
#   ["ate","eat","tea"],
#   ["nat","tan"],
#   ["bat"]
# ] 
# 
#  说明： 
# 
#  
#  所有输入均为小写字母。 
#  不考虑答案输出的顺序。 
#  
#  Related Topics 哈希表 字符串
import collections
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        '''
        res_dict = collections.defaultdict(list)
        for s in strs:
            s_sort = "".join(sorted(s))
            res_dict[s_sort].append(s)
        return res_dict.values()
        '''
        ''''''
        res_dict = collections.defaultdict(list)
        for st in strs:
            a = [0] * 26
            for l in st:
                a[ord(l) - ord('a')] += 1
            res_dict[tuple(a)].append(st)
        return res_dict.values()



strings = ["eat", "tea", "tan", "ate", "nat", "bat"]
print(Solution().groupAnagrams(strings))
        
# leetcode submit region end(Prohibit modification and deletion)

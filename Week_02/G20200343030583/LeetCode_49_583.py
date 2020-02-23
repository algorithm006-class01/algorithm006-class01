#
# @lc app=leetcode id=49 lang=python
#
# [49] Group Anagrams
# hash function: sort, map str to a sorted_str

# @lc code=start
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        if len(strs) == 0:
            return []
        map = dict()

        for str in strs:
            sorted_str = ''.join(sorted(str))
            if sorted_str not in map:
                map[sorted_str] = [str]
            else:
                map[sorted_str].append(str)
            # use dict.get() will be slower
            # map[sorted_str] = map.get(sorted_str,[]) + [str]
        return list(map.values())
# @lc code=end


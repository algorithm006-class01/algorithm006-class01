"""
    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

    示例:
        输入:
            ["eat", "tea", "tan", "ate", "nat", "bat"],
        输出:
            [
              ["ate","eat","tea"],
              ["nat","tan"],
              ["bat"]
            ]
        说明：
            所有输入均为小写字母。
            不考虑答案输出的顺序。
"""
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        return self.count_and_group(strs)

    @classmethod
    def count_and_group(cls, strs: List[str]) -> List[List[str]]:
        """
            计数分类 两层循环
            第一层循环：
                遍历输入列表
                生成一个里面包含26个0的列表
                执行完第二层循环后更新的列表，将其转为元祖，当成hash表的key
                如果key存在就更新对应的value，不存在就初始化一个列表，将value添加到列表中。
            第二层循环：
                再遍历对应的元素：
                    通过ord函数计算出字母对应的ascii码值，
                    并且减去a的ascii码值，得到结果就是第一层循环里面列表中的下标，然后将下标的值+1。
            时间复杂度：O(nk)，空间复杂度:O(nk)
        """
        hash_map = {}
        for s in strs:
            nums = [0] * 24
            for i in s:
                nums[ord(i) - ord("a")] += 1
            nums_tuple = tuple(nums)

            if nums_tuple not in hash_map:
                hash_map[nums_tuple] = [s]
            else:
                hash_map[nums_tuple].append(s)
        return list(hash_map.values())

    @classmethod
    def sort_and_group(cls, strs: List[str]) -> List[List[str]]:
        """
            排序分组处理：
                1)遍历给定列表中的每一个字符串
                2)将每个字符串排序得到一个有序列表，再将列表转换为元组。
                3)判断元组是不是在哈希表中，
                  3.1 如果不在将hash表中，则将元祖传入到哈希表中，并且给元祖对应的值初始化一个列表，将遍历得到的字符串插入到列表中。
                  3.2 如果在hash表中，将该字符串追加到对应的列表中。
                4)输出哈希表中的所有值。
            时间复杂度：O(nklogk) k为元素中最长字符串的长度
            空间复杂度：O(nk)
        """

        hash_map = {}

        for s in strs:
            sort_s = tuple(sorted(s))
            if sort_s not in hash_map:
                hash_map[sort_s] = [s]
            else:
                hash_map[sort_s].append(s)
        return list(hash_map.values())

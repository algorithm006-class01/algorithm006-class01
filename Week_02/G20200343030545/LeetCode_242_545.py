"""
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
"""
import string


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        pass

    @classmethod
    def directly(cls, s: str, t: str) -> bool:
        """
            暴力求解法：
                对两个字符串分别进行排序，然后做等值判断。如果相等则说明是字母异位词。
            时间复杂度：O(nlogn)，空间复杂度：O(1)
            这个方法也适合unicode字符
        """
        return sorted(s) == sorted(t)

    @classmethod
    def use_array(cls, s: str, t: str) -> bool:
        """
            使用列表，初始化一个有26个元素的且，每个元素的值都为0的列表。
            1)
                1.1 循环遍历s，获取s中的元素。
                1.2 计算出元素对应的ascii值，并且减去字母a的ascii码值。
                1.3 得到的结果就是这个元素在初始化列表中的下标位置，然后该下标位置的值+1。
            2) 和1)基本一样，只不过不同于1.3步，最后要对相应下标的值-1。
            3) 遍历列表，如果列表中有元素的值大于1，直接返回False，否则返回True。

            时间复杂度：O(n)，空间复杂度：O(1)
            TODO:这中解法只适用于两个输入都是小写字母。
        """
        nums = [0] * 26
        # Step 1
        for s_one in s:
            nums[ord(s_one) - ord('a')] += 1

        # Step 2
        for t_one in t:
            nums[ord(t_one) - ord('a')] -= 1

        # Step 3
        for num in nums:
            if num:
                return False
        return True

    @classmethod
    def use_hash_1(cls, s: str, t: str) -> bool:
        """
            使用哈希表，3步遍历。
            1）遍历s，输出s的每个元素到哈希表中。
                如果该元素不存在，将该元素赋到哈希表中，并且赋予该元素在哈希表中的初始值为1。
                如果该元素存在，更新该元素在哈希表中的值+1。
            2)遍历t, 输出m的每个元素到哈希表中。
                如果该元素不存在，将该元素赋到哈希表中，并且赋予该元素在哈希表中的初始值为1。
                如果该元素存在，更新该元素在哈希表中的值-1。
            3)遍历哈希表，如果哈希表中有元素对应的值大于1，直接返回False。循环遍历完后返回True。

            时间复杂度：O(n)，空间复杂度：O(n)

            这个方法也适合unicode字符
        """
        hash_map = {}

        # Step 1
        for s_one in s:
            if s_one in hash_map:
                hash_map[s_one] += 1
            else:
                hash_map[s_one] = 1

        # Step 2
        for t_one in t:
            if t_one in hash_map:
                hash_map[t_one] -= 1
            else:
                hash_map[t_one] = 1

        # Step 3
        for k, v in hash_map.items():
            if v:
                return False
        return True

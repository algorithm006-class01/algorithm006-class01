class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        # if len(s) != len(t):
        #     return False
        #
        # letter = {}
        # for i in s:
        #     if i in letter.keys():
        #         letter[i] += 1
        #     else:
        #         letter[i] = 1
        #
        # for i in t:
        #     if i in letter.keys():
        #         letter[i] -= 1
        #     else:
        #         return False
        #
        # for _, v in letter.items():
        #     if v != 0:
        #         return False
        # return True

        if len(s) != len(t): return False
        if s == t: return True

        se = set(s)
        if se == set(t):
            for i in se:
                if s.count(i) != t.count(i): return False
            return True
        else:
            return False
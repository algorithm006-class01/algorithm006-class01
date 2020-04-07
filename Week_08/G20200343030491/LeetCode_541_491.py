class Solution:
    def reverseStr(self, s, k):
        length = len(s)
        if length < k:
            return s[::-1]
        if k <= length <= 2*k:
            return s[k-1::-1] + s[k:]
        if length > 2*k:
            return s[k-1::-1] + s[k:2*k] + self.reverseStr(s[2*k:],k)


class Solution:
    def reverseStr(self, s, k):
        s = list(s)
        for i in range(0, len(s), 2*k):
            s[i:i+k] = reversed(s[i:i+k])
        return "".join(s)
class Solution:
    def reverseWords(self, s: str) -> str:
        s = s[::-1].split()
        for i in range(len(s)):
            s[i] = s[i][::-1]
        return ' '.join(s)

class Solution:
    def reverseWords(self, s: str) -> str:
        return ' '.join(reversed(s.split()))
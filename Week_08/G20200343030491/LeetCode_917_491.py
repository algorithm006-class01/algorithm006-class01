class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        s = list(S)
        l, r = 0, len(s)-1
        while l<r:
            if s[l] in string.ascii_letters and s[r] in string.ascii_letters:
                s[l], s[r] = s[r], s[l]
                l += 1
                r -= 1
            if s[l] in string.ascii_letters and s[r] not in string.ascii_letters:
                r -= 1
            if s[l] not in string.ascii_letters and s[r] in string.ascii_letters:
                l += 1
            if s[l] not in string.ascii_letters and s[r] not in string.ascii_letters:
                l += 1
                r -= 1

        return ''.join(s)
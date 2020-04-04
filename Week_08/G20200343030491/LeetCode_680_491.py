class Solution:
    def validPalindrome(self, s: str) -> bool:
        l, r = 0, len(s)-1
        while l<r:
            if s[l] != s[r]:
                one, two = s[l:r], s[l+1:r+1]
                return one == one[::-1] or two == two[::-1]
            l, r = l+1, r-1
            
        return True
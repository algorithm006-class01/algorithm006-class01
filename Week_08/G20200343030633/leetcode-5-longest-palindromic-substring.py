# 遍历，从中心展开
def longestPalindrome(s):
    if len(s) == 0:
        return ""
    start = 0
    end = 0
    for i in range(len(s)):
        len1 = expandAroundCenter(s, i, i)
        len2 = expandAroundCenter(s, i, i + 1)
        result = max(len1, len2)
        if result > (end - start):
            start = i - (result - 1) / 2
            end = i + result / 2
    return s[start:end + 1]


def expandAroundCenter(s, left, right):
    while left >= 0 and right \
            < len(s) and s[left] == s[right]:
        left -= 1
        right += 1
    return right - left - 1

// https://leetcode-cn.com/problems/valid-palindrome-ii/

const validPalindrome = function (s, count = 0) {
    for (let i = 0, j = s.length - 1; i < j; i++, j--) {
        if (s[i] === s[j]) continue;
        if (count > 0) return false;
        return validPalindrome(s.slice(i, j), count + 1) || validPalindrome(s.slice(i + 1, j + 1), count + 1);
    }
    return true;
};
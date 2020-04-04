// https://leetcode-cn.com/problems/valid-palindrome/

const isPalindrome = function (s) {
    s = s.replace(/[^0-9a-zA-Z]/g, '').toLowerCase();
    let n = s.length;
    let left = 0;
    let right = n - 1;
    while (left < right) {
        if (s[left] != s[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
};
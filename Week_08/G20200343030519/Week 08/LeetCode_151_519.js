// https://leetcode-cn.com/problems/reverse-words-in-a-string/

const reverseWords = function (s) {
    return s.trim().split(/\s+/).reverse().join(" ")
};
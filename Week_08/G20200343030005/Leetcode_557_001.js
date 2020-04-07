// 557. 反转字符串中的单词 III https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/

/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function (s) {
  let arr = s.split("").reverse().join("");
  return arr.split(" ").reverse().join(" ");
};

var reverseWords = function (s) {
  return s.split("").reverse().join("").split(/\s+/).reverse().join(" ");
};

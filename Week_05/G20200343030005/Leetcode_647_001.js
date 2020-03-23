// 647. 回文子串 https://leetcode-cn.com/problems/palindromic-substrings/

/**
 * @param {string} s
 * @return {number}
 */
var countSubstrings = function(s) {
  let s2 = s
    .split("")
    .reverse()
    .join("");
  let sum = 0;
  const len = s.length;
  for (let i = 0; i < len; i++) {
    for (let j = i + 1; j <= len; j++) {
      if (s.substr(i, j - i) === s2.substr(len - j, j - i)) {
        sum += 1;
      }
    }
  }
  return sum;
};
var str = "abc";
var str = "aaa";
console.log(countSubstrings(str));

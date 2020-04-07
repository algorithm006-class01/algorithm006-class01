// 917. 仅仅反转字母 https://leetcode-cn.com/problems/reverse-only-letters/
/**
 * @param {string} S
 * @return {string}
 */
var reverseOnlyLetters = function (S) {
  var arr = S.match(/[a-zA-Z]/g);
  if (arr === null) return S;
  return S.replace(/[a-zA-Z]/g, () => arr.pop());
};

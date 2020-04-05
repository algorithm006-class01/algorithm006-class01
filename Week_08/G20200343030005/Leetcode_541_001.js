// 541. 反转字符串 II https://leetcode-cn.com/problems/reverse-string-ii/

/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reverseStr = function (s, k) {
  let result = [];
  let n = 2 * k;
  let len = Math.ceil(s.length / n);
  for (let i = 0; i < len; i++) {
    result.push(s.substr(n * i, n));
  }
  result = result.map((item) => {
    return item.substr(0, k).split("").reverse().join("") + item.substr(k);
  });
  return result.join("");
};

/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reverseStr = function (s, k) {
  var result = "";
  var isReverse = false;
  for (var i = 0, len = s.length; i < len; i += k) {
    var str = s.slice(i, i + k);
    result += isReverse ? str : str.split("").reverse().join("");
    isReverse = !isReverse;
  }
  return result;
};

// 191. 位1的个数  https://leetcode-cn.com/problems/number-of-1-bits/
/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
  return n
    .toString(2)
    .split("")
    .reduce((t, n) => +t + +n);
};

var hammingWeight = function(n) {
  return n.toString(2).replace(/0/g, "").length;
};
var hammingWeight = function(n) {
  let count = 0;
  while (n) {
    count += n % 2;
    n = n >> 1;
    // n = Math.floor(n / 2);
  }
  return count;
};
var hammingWeight = function(n) {
  let counts = 0;
  while (n) {
    counts++;
    n &= n - 1;
  }
  return counts;
};

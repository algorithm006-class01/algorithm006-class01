// 231. 2的幂 https://leetcode-cn.com/problems/power-of-two/
/**
 * @param {number} n
 * @return {boolean}
 */
/* 解法一：2的幂数的数字的二进制特点 + 位操作
2的幂数的数字的二进制有且只有一个1，其余均是0
n & (n-1)：清零最低位的1
合起来 n & (n-1) == 0 */

var isPowerOfTwo = function(n) {
  return n > 0 && (n & (n - 1)) == 0;
};
// 解法二：调用函数懒蛋法
var isPowerOfTwo = function(n) {
  return Number.isInteger(Math.log2(n));
};
// 解法三：位运算
var isPowerOfTwo = function(n) {
  return n > 0 && (n & -n) == n;
};
// 解法四：取模
/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
  while (n > 1) {
    n /= 2;
  }
  if (n == 1) {
    return true;
  } else {
    return false;
  }
};

// 题目: 2的幂
/**
 * 题目描述：
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

 */

 // 解题语言: javaScript

 // 解题

 /**
  * @param {nember} n
  * @return {boolean}
  */
 var isPowerOfTwo = function (n) {
     return n > 0 && (n & (n - 1)) == 0
 }
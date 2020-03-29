// 题目: 位1的个数
/**
 * 题目描述：
编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。

 */

 // 解题语言: javaScript

 // 解题

 /**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let count = 0
    while (n !== 0) {
        n = n & (n - 1)
        count++
    }
    return count
};
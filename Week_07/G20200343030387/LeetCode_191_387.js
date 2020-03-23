/**
 * @param {number} n - a positive integer
 * @return {number}
 */
// n与n-1的与运算可以消除其二进制上的最后一位1
// 遍历次数为bit位为1的个数
var hammingWeight = function (n) {
    let count = 0
    while (n !== 0) {
        n &= n - 1
        count++
    }
    return count
};
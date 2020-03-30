/**
 * @param {number} n
 * @return {boolean}
 */
// 2 的幂次方的数需要满足二进制位上只有一个1
// 需要大于0，且消除掉一位后等于0
var isPowerOfTwo = function (n) {
    return n > 0 && (n & (n - 1)) === 0
};
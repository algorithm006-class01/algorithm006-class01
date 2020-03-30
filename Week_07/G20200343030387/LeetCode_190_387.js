/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function (n) {
    let res = 0
    for (let i = 0; i < 32; i++) {
        res <<= 1
        res += (n & 1)
        n >>>= 1
    }
    // 在js中所有的按位操作符都会会转换为补码进行，最后一位为1左移时会溢出，所有需要使用>>>变成无符号整数
    return res >>> 0
};
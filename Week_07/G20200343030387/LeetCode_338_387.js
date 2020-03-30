/**
 * @param {number} num
 * @return {number[]}
 */
// 动态规划 + 最低有效位
// 任何一个数x的二进制数1的数目可以看成x右移1位的数，加上x原来的最低有效位1的数目；
// 状态：P(x)表示x的二进制数1的数目
// DP方程：P(x) = P(x>>>1) + (x & 1)
// 注：js的 >>> 才是逻辑右移，>> 是算术右移
var countBits = function (num) {
    const res = [0]
    for (let i = 0; i <= num; i++) {
        res[i] = res[i >>> 1] + (i & 1)
    }
    return res
};
/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */

// 暴力法
// LeetCode校验会超时，可能是js运行太慢了
const fastPow1 = function (x, n) {
    let N = n
    if (N < 0) {
        N = -N
        x = 1 / x
    }
    let res = 1
    for (let i = 0; i < N; i++) {
        res *= x
    }
    return res
}

// 快速幂算法（递归）
// n为偶数：
// x^n = x^(n/2) * x^(n/2)
//     = x^(n/4) * x^(n/4) * x^(n/4) * x^(n/4)
//     = ...
// 兼容奇数情况，n减半时要取整数，最后再乘多一个x：
// x^n = x^(n/2) * x^(n/2) * x
//     = x^(n/4) * x^(n/4) * x^(n/4) * x^(n/4) * x
//     = ...
// 找到重复性，进行递归
const fastPow = function (x, n) {
    if (n === 0) {
        return 1
    }
    const half = fastPow(x, parseInt(n / 2))
    if (n % 2 === 0) {
        return half * half
    } else {
        return half * half * x
    }
}
const myPow = function (x, n) {
    let N = n
    // 数学知识：指数小于0时，2^-2 = (1/2)^2
    if (N < 0) {
        x = 1 / x
        N = -N
    }

    return fastPow(x, N)
};


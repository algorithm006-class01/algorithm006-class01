/*
* address: https://leetcode-cn.com/problems/power-of-two/
* */
const isPowerOfTwo = function(n) {
    return Number.isInteger(Math.log2(n));
};

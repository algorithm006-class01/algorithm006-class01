// https://leetcode-cn.com/problems/plus-one/

var plusOne = function(digits) {
    for (let i = digits.length - 1; i >= 0; i--) {
        digits[i]++;
        digits[i] = digits[i] % 10;
        if (digits[i] !== 0) return digits;
    }
    digits = new Array(digits.length + 1).fill(0);
    digits[0] = 1;
    return digits;
};
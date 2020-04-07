// https://leetcode-cn.com/problems/string-to-integer-atoi/

const myAtoi = function (str) {
    const number = parseInt(str, 10);

    if (isNaN(number)) {
        return 0;
    } else if (number < Math.pow(-2, 31) || number > Math.pow(2, 31) - 1) {
        return number < Math.pow(-2, 31) ? Math.pow(-2, 31) : Math.pow(2, 31) - 1;
    } else {
        return number;
    }
};
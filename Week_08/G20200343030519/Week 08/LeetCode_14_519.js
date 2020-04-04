// https://leetcode-cn.com/problems/longest-common-prefix/description/

var longestCommonPrefix = function (strs) {
    if (!strs.length) return '';

    for (let i = 0; i < strs[0].length; i++) {
        for (let str of strs) {
            if (str[i] !== strs[0][i]) {
                return str.slice(0, i);
            }
        }
    }

    return strs[0];
}
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function (s) {
    s = s.trim()
    const n = s.length
    for (let i = n - 1; i >= 0; i--) {
        if (s[i] === ' ') {
            return n - i - 1
        }
    }
    return n
};
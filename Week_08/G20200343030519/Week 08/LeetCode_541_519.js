// https://leetcode-cn.com/problems/reverse-string-ii/

const reverseStr = function (s, k) {
    if (s.length <= k) return s.split("").reverse().join("");
    let res = [];
    s = s.split("");
    while (s.length > k) {
        res.push(...(s.splice(0, k).reverse()));
        res = res.concat(s.splice(0, k));
    }
    res.push(...(s.reverse()));
    return res.join("");
};
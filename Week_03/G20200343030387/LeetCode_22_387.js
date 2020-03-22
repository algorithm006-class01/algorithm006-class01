/**
 * @param {number} n
 * @return {string[]}
 */
// 想象有2n个格式，每个格子放一个左或右括号，并且满足成对的形式
// 最近重复性是放左格号或右括号
var generateParenthesis = function (n) {
    const res = []
    const recursion = function (left, right, n, str) {
        if (left >= n && right >= n) {
            res.push(str)
            return
        }
        // 剪枝
        // 左括号不超限
        if (left < n) {
            recursion(left + 1, right, n, str + '(')
        }
        // 已经有左括号，且右括号数量少于左括号数量
        if (left > right) {
            recursion(left, right + 1, n, str + ')')
        }
    }
    recursion(0, 0, n, '')
    return res
};
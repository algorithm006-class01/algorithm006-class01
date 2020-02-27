/**
 * @param {string} digits
 * @return {string[]}
 */
// digits.length个格子，放置phone的数字对应的字母；
// 每个数字有三个字母，相当于每个格子有三种可能（三叉树）；
const buildPhone = function () {
    const phone = new Map()
    phone.set("2", "abc")
    phone.set("3", "def")
    phone.set("4", "ghi")
    phone.set("5", "jkl")
    phone.set("6", "mno")
    phone.set("7", "pqrs")
    phone.set("8", "tuv")
    phone.set("9", "wxyz")
    return phone
}
var letterCombinations = function (digits) {
    if (!digits.length) return []
    const phone = buildPhone()
    const res = []
    const size = digits.length
    const reversion = function (level, str) {
        if (level >= size) {
            res.push(str)
            return
        }
        phone.get(digits[level]).split('').forEach(c => {
            reversion(level + 1, str + c)
        })
    }
    reversion(0, '')
    return res
};
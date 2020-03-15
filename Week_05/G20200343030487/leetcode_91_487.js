/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function (s) {
  if (s[0] === '0') {
    return 0
  }
  let len = s.length
  let res = [1, 1]
  for (let i = 1; i < len; i++) {
    if (s[i] === '0') {
      if (s[i - 1] === '1' || s[i - 1] === '2') {
        res[i + 1] = res[i - 1]
      } else {
        return 0
      }
    } else {
      if (s[i - 1] === '1' || (s[i - 1] === '2' && s[i] <= '6')) {
        res[i + 1] = res[i] + res[i - 1]
      } else {
        res[i + 1] = res[i]
      }
    }
  }
  return res[len]
}

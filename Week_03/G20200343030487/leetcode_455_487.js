/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function (g, s) {
  g.sort((a, b) => { return a - b })
  s.sort((a, b) => { return a - b })
  let count = 0, i = 0, j = 0
  while (i < g.length && j < s.length) {
    if (g[i] <= s[j]) {
      count++
      i++
      j++
    } else {
      j++
    }
  }
  return count
}

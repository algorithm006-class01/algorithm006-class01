/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
  if (!matrix.length) return false
  let row = 0, col = matrix[0].length - 1
  while (row < matrix.length && col > -1) {
    if (matrix[row][col] < target) {
      row++
    } else if (matrix[row][col] > target) {
      col--
    } else {
      return true
    }
  }
  return false
}

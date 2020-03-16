/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
  if (!grid.length || !grid[0].length) {
    return 0
  }
  const arr = new Array(grid[0].length).fill(Infinity)
  arr[0] = 0
  for (let i = 0; i < grid.length; i++) {
    arr[0] += grid[i][0]
    for (let j = 1; j < grid[i].length; j++) {
      arr[j] = Math.min(arr[j], arr[j - 1]) + grid[i][j]
    }
  }
  return arr[arr.length - 1]
}

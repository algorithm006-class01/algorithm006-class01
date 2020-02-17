// 不是很理解第一个数组后面的0
function mergeSortedArray(arr1, m, arr2, n) {
  arr1.splice(m, n, ...arr2)
  arr1.sort((a, b) => {
      return a - b
  })
}
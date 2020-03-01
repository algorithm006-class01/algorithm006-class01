/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
// 将二维数组降至一维；
// 因为其单调递增，所以用十分法求目标值；
// 找到则返回true, 遍历到最后返回false；
var searchMatrix1 = function (matrix, target) {
    if (!matrix.length) return false
    matrix.forEach(item => {
        matrix[0] = matrix[0].concat(item)
    })
    if (!matrix[0].length) return false
    let left = 0
    let right = matrix[0].length - 1
    let mid = 0
    while (left <= right) {
        mid = parseInt((left + right) / 2)
        if (matrix[0][mid] === target) {
            return true
        }
        if (matrix[0][mid] > target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return false
};


// 想象所有元素拼接成虚拟数组；
// 虚拟数组元素的索引index转换为矩阵的行列位置；
// 行：index / n；列：index % n
var searchMatrix = function (matrix, target) {
    const m = matrix.length
    if (m === 0) return false
    const n = matrix[0].length
    let left = 0
    let right = m * n - 1
    let mid = 0
    let midx = 0
    let nidx = 0
    while (left <= right) {
        mid = parseInt((left + right) / 2)
        midx = parseInt(mid / n)
        nidx = parseInt(mid % n)
        if (matrix[midx][nidx] === target) {
            return true
        }
        if (matrix[midx][nidx] > target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return false
}
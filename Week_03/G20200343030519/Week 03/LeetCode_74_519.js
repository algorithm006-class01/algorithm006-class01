// https://leetcode-cn.com/problems/search-a-2d-matrix/

var searchMatrix = function(matrix, target) {
    var m = matrix.length;
    if (m == 0) return false;
    var n = matrix[0].length;
    var low = 0;
    var high = m * n - 1;
    while (low <= high) {
        var mid = (low + high) >> 1;
        var row = parseInt(mid / n);
        var col = mid % n;
        var matrixMid = matrix[row][col];
        if (matrixMid < target) {
            low = mid + 1;
        } else if (matrixMid > target) {
            high = mid -1;
        } else if (matrixMid == target) {
            return true;
        }
    }
    return false;
};
/*
 * https://leetcode-cn.com/problems/search-a-2d-matrix/submissions/
 * 74. 搜索二维矩阵
 */
package leetcode

func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return false
	}
	for start, end := 0, len(matrix)*len(matrix[0])-1; start <= end; {
		mid := (start + end) / 2
		if v := getMidVal(matrix, mid); v == target {
			return true
		} else if v < target {
			start = mid + 1
		} else {
			end = mid - 1
		}
	}
	return false
}

func getMidVal(matrix [][]int, i int) int {
	j := i / len(matrix[0])
	return matrix[j][i%len(matrix[0])]
}

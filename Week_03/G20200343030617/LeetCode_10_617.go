// 74. 搜索二维矩阵

package main

func searchMatrix(matrix [][]int, target int) bool {
	rowNum := len(matrix)
	if rowNum == 0 {
		return false
	}
	var lineNum int
	if len(matrix[0]) > 0 {
		lineNum = len(matrix[0])
	} else {
		return false
	}
	left, right := 0, rowNum*lineNum
	for left <= right {
		mid := left + (right-left)/2
		i := mid / lineNum
		j := mid % lineNum
		if i >= rowNum || j >= lineNum {
			return false
		}
		if matrix[i][j] == target {
			return true
		} else if matrix[i][j] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return false
}

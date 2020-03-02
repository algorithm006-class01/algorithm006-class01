//https://leetcode-cn.com/problems/search-a-2d-matrix/
package search_2d_matrix_t_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestSearchMatrix(t *testing.T) {
	t.Log("Binary Search: Search 2d Matrix")
	matrix1 := [][]int{
		{1, 3, 5, 7},
		{10, 11, 16, 20},
		{23, 30, 34, 50},
	}
	assert.Equal(t, true, searchMatrix(matrix1, 3))

	matrix2 := [][]int{
		{1, 3, 5, 7},
		{10, 11, 16, 20},
		{23, 30, 34, 50},
	}
	assert.Equal(t, false, searchMatrix(matrix2, 13))
}

func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return false
	}

	l, r := 0, len(matrix)-1
	for l < r {
		mid := (l + r + 1) >> 1
		if matrix[mid][0] > target {
			r = mid - 1
		} else {
			l = mid
		}
	}
	if matrix[l][0] > target {
		return false
	}

	array := matrix[l]
	l, r = 0, len(array)-1
	for l < r {
		mid := (l + r) >> 1
		if array[mid] < target {
			l = mid + 1
		} else {
			r = mid
		}
	}
	return array[l] == target
}

//https://leetcode-cn.com/problems/plus-one/
package plus_one_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestPlusOne(t *testing.T) {
	digits1 := []int{1, 2, 3}
	expect1 := []int{1, 2, 4}
	assert.Equal(t, expect1, plusOne(digits1))

	digits2 := []int{1, 2, 9}
	expect2 := []int{1, 3, 0}
	assert.Equal(t, expect2, plusOne(digits2))

	digits3 := []int{9, 9}
	expect3 := []int{1, 0, 0}
	assert.Equal(t, expect3, plusOne(digits3))
}

//模拟进位
//从后往前遍历
//如果数字小于9，直接加一，直接返回
//如果数字等于9。本位变零，向前看一位，同样与9判断大小
//如果没有在小于9的地方返回，即每一位都是9。在遍历结束后首位加个1
func plusOne(digits []int) []int {
	for i := len(digits) - 1; i >= 0; i-- {
		if digits[i] < 9 {
			digits[i]++
			return digits
		} else {
			digits[i] = 0
		}
	}
	return append([]int{1}, digits...)
}

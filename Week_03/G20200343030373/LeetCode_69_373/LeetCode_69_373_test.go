//https://leetcode-cn.com/problems/sqrtx/
package sqrt_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestSqrt(t *testing.T) {
	assert.Equal(t, 2, mySqrt(4))
	assert.Equal(t, 2, mySqrt(8))
	assert.Equal(t, 2, binarySearchSqrt(4))
	assert.Equal(t, 2, binarySearchSqrt(8))
	assert.Equal(t, 2, newtonSqrt(4))
	assert.Equal(t, 2, newtonSqrt(8))

	//expect1, _ := strconv.ParseFloat(fmt.Sprintf("%.5f", math.Sqrt(2)), 64)
	//expect2, _ := strconv.ParseFloat(fmt.Sprintf("%.10f", math.Sqrt(2)), 64)
	//assert.Equal(t, expect1, floatSqrt(2, 5))
	//assert.Equal(t, expect2, floatSqrt(2, 10))
}

func mySqrt(x int) int {
	return binarySearchSqrt(x)
}

func binarySearchSqrt(x int) int {
	if x == 0 || x == 1 {
		return x
	}
	//题目要求返回int，所以left从1开始
	left, right := 1, x
	//left, right, res := 1, x, 0
	for left <= right {
		//mid := (left + right) / 2 会溢出
		mid := left + (right-left)/2
		//mid * mid == x 会溢出
		if mid == x/mid {
			return mid
		} else if mid > x/mid {
			right = mid - 1
		} else {
			left = mid + 1
			//res = mid
		}
	}
	//left和right逐渐逼近，是向下取整，当left+1时跳出循环，大于了mid，所以结果就是 left-1 或者上一次的 mid
	return left - 1
	//return res
}

func newtonSqrt(x int) int {
	if x == 0 {
		return 0
	}

	r := x
	//除数不能为0
	for r > x/r {
		r = (r + x/r) / 2
	}
	return r
}

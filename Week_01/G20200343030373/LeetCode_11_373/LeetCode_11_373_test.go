//https://leetcode-cn.com/problems/container-with-most-water/
package container_with_most_water_t_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestMaxArea(t *testing.T) {
	height := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	assert.Equal(t, 49, maxArea(height))
	assert.Equal(t, 49, enumArea(height))
	assert.Equal(t, 49, shrinkArea(height))
}

func maxArea(height []int) int {
	return shrinkArea(height)
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

//暴力求解
//从左到右，对于每一个元素，枚举出与其右边元素组成的面积，比较最大值
//O(n^2)
func enumArea(height []int) int {
	maxArea := 0
	for i := 0; i < len(height); i++ {
		for j := i + 1; j < len(height); j++ {
			maxArea = max(maxArea, (j-i)*min(height[i], height[j]))
		}
	}
	return maxArea
}

//左右夹逼
//最左侧到最右侧的宽度最长，具有第一优势，然后左右分别向中间收敛，收敛的过程中比较最大值
//收敛时，左右两个边界中的较小值，才需要去移动寻找下一个值
//O(n)
func shrinkArea(height []int) int {
	maxArea := 0
	for i, j := 0, len(height)-1; i < j; {
		maxArea = max(maxArea, (j-i)*min(height[i], height[j]))
		if height[i] < height[j] {
			i++
		} else {
			j--
		}
	}
	return maxArea
}

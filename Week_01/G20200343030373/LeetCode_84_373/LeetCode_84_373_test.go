//https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
package largest_rectangle_in_histogram_t_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestLargestArea(t *testing.T) {
	t.Log("Largest Rectangle in Histogram")
	heights := []int{2, 1, 5, 6, 2, 3}
	assert.Equal(t, 10, largestRectangleArea(heights))
}

func largestRectangleArea(heights []int) int {
	return stackIncrease(heights)
}

//暴力求解1
//找到左边界
//找到右边界
//找到左右边界中面积最大的情况
//O(n^3)
//Not AC, Time Out
func bruteForce1(heights []int) int {
	maxArea := 0
	n := len(heights)
	for i := 0; i <= n-1; i++ { //左边界	//要考虑只有一个元素的情况, i可达右边界
		for j := n - 1; j >= i; j-- { //右边界	//要考虑只有一个元素的情况, j可达左边界
			minHeight := heights[i]
			for k := i; k <= j; k++ { //中间最低	//k可达边界
				if heights[k] < minHeight {
					minHeight = heights[k]
				}
			}
			if area := minHeight * (j - i + 1); area > maxArea {
				maxArea = area
			}
		}
	}
	return maxArea
}

//暴力求解2
//遍历柱子
//和其他柱子的面积的所有组合，找到最大
//O(n^2)
//AC, 776ms
func bruteForce2(heights []int) int {
	maxArea := 0
	n := len(heights)
	for i := 0; i < n; i++ {
		minHeight := heights[i]
		for j := i; j < n; j++ {
			if heights[j] < minHeight {
				minHeight = heights[j]
			}
			if area := minHeight * (j - i + 1); area > maxArea {
				maxArea = area
			}
		}
	}
	return maxArea
}

//左右发散
//先确定高度，再确定宽度
//遍历每个值作为高度，向左向右查找小于该高度或超出边界为止
//l和r对应是取不到的边界值，宽度为r-l-1
//O(n^2), 548ms
func leftRightOut(heights []int) int {
	maxArea := 0
	n := len(heights)
	for i := 0; i < n; i++ {
		l, r := i, i //左右边界
		for l >= 0 && heights[l] >= heights[i] {
			l--
		}
		for r < n && heights[r] >= heights[i] {
			r++
		}
		if area := heights[i] * (r - l - 1); area > maxArea {
			maxArea = area
		}
	}
	return maxArea
}

//辅助栈
//栈维护一个 下标 序列，对应直方图高度依次递增
//把 -1 放进栈的顶部来表示开始
//当下一个值right小于栈顶下表的值cur，对于栈顶下标这个柱子来说
//- right是cur的右边界
//- cur的前一个元素left是它的左边界
//O{n), 8ms; O(n)
func stackIncrease(heights []int) int {
	maxArea := 0
	n := len(heights)
	var stack []int //用切片实现栈
	for r := 0; r <= n; r++ {
		h := 0     //高度，右边界越界时为0
		if r < n { //右边界不越界
			h = heights[r]
		}

		for len(stack) > 0 && h < heights[stack[len(stack)-1]] {
			cur := stack[len(stack)-1]   //栈顶元素
			stack = stack[:len(stack)-1] //弹出栈顶元素

			l := -1             //左边界越界时为-1
			if len(stack) > 0 { //左边界不越界
				l = stack[len(stack)-1]
			}

			if area := heights[cur] * (r - l - 1); area > maxArea {
				maxArea = area
			}
		}
		stack = append(stack, r)
	}
	return maxArea
}

//https://leetcode-cn.com/problems/trapping-rain-water/
package trapping_rain_water_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestTrap(t *testing.T) {
	height1 := []int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
	assert.Equal(t, 6, trap(height1))
	assert.Equal(t, 6, rowTrap(height1))
	assert.Equal(t, 6, colTrap(height1))
	assert.Equal(t, 6, dpTrap(height1))
	assert.Equal(t, 6, dualPointerTrap(height1))
	assert.Equal(t, 6, stackTrap(height1))

	height2 := []int{2, 0, 2}
	assert.Equal(t, 2, trap(height2))
	assert.Equal(t, 2, rowTrap(height2))
	assert.Equal(t, 2, colTrap(height2))
	assert.Equal(t, 2, dpTrap(height2))
	assert.Equal(t, 2, dualPointerTrap(height2))
	assert.Equal(t, 2, stackTrap(height2))
}

//参考：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/

func trap(height []int) int {
	//Most Understandable
	return dpTrap(height)
}

//common
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

//method1: 按行求
//原则：高度i, 遇到高度小于i的先存起来temp++; 遇到大于等于i的就把存起来的水放到答案sum+=temp中并temp=0置零
//TC: O(mn), SC: O(1)
//AC, 1160ms, too long
func rowTrap(height []int) int {
	sum := 0
	max := maxHeight(height)    //最大高度，遍历
	for i := 1; i <= max; i++ { //第一行，i从1开始
		isStart := false //标记是否开始更新temp，因为需要找到第一个h>=i的才能开始蓄水
		temp := 0        //暂存的水
		//原则：h<i, temp++; h>=i, sum += temp, temp=0
		for _, h := range height {
			if isStart && h < i {
				temp++
			}
			if h >= i {
				sum += temp
				temp = 0
				isStart = true
			}
		}
	}
	return sum
}

func maxHeight(height []int) int {
	max := 0
	for _, h := range height {
		if h > max {
			max = h
		}
	}
	return max
}

//method2: 按列求
//原则：当前列，蓄水量：min(左边最高、右边最高)-h；如果较小值比当前列 小或相等，当前列不会蓄水
//TC: O(n^2), SC: O(1)
//AC, 88ms, Good
func colTrap(height []int) int {
	sum := 0
	length := len(height)
	//两端的列无需考虑
	for i := 1; i <= length-2; i++ {
		maxLeft, maxRight := 0, 0
		for j := i - 1; j >= 0; j-- {
			if height[j] > maxLeft {
				maxLeft = height[j]
			}
		}
		for j := i + 1; j <= length-1; j++ {
			if height[j] > maxRight {
				maxRight = height[j]
			}
		}

		min := min(maxLeft, maxRight)

		if min > height[i] {
			sum += min - height[i]
		}
	}
	return sum
}

//method3: 动态规划
//原则：对于当前列找左右的最大值，可以记忆
//状态定义：dpMaxLeft[i]，i左边的最高值；dpMaxRight[i]，i右边的最高值，不包括当前列i
//状态方程：dpMaxLeft[i] = max(dpMaxLeft[i-1], height[i-1]); dpMaxRight[i]同理
//TC: O(n), SC: O(n) - 加速：空间换时间
//AC, 4ms, Better
func dpTrap(height []int) int {
	sum := 0
	length := len(height)

	dpMaxLeft, dpMaxRight := make([]int, length), make([]int, length)
	for i := 1; i <= length-2; i++ {
		dpMaxLeft[i] = max(dpMaxLeft[i-1], height[i-1])
	}
	for i := length - 2; i >= 1; i-- {
		dpMaxRight[i] = max(dpMaxRight[i+1], height[i+1])
	}

	for i := 1; i <= length-2; i++ {
		min := min(dpMaxLeft[i], dpMaxRight[i])
		if min > height[i] {
			sum += min - height[i]
		}
	}
	return sum
}

//method4: 双指针法
//动态规划中，常常可以对最大值、最小值的状态方程过程，进行空间复杂度的优化
//dpMaxLeft[i],dpMaxRight[i]在整个遍历过程中仅使用1次，可以不用数组挨个记录，用一个元素重复刷新
//状态定义：dpMaxLeft: i左边的最高值
//状态方程：dpMaxLeft = math(dpMapLeft, height[i-1])
//问题：数组dpMaxRight不能降维到一个元素，因为最终的遍历是从左到右 -> 因此使用双指针left、right， 从两个方向遍历
//如果一端有更高的条形块（例如右端），积水的高度依赖于当前方向的高度（从左到右）。当发现另一侧（右侧）的条形块高度不是最高的，则开始从相反的方向遍历（从右到左）
//TC: O(n), SC: O(1)
func dualPointerTrap(height []int) int {
	sum := 0
	length := len(height)
	dpMaxLeft, dpMaxRight := 0, 0
	pLeft, pRight := 1, length-2
	for i := 1; i <= length-2; i++ {
		if height[pLeft-1] < height[pRight+1] {
			//从左到右遍历，则dpMaxLeft也小于dpMaxRight
			dpMaxLeft = max(dpMaxLeft, height[pLeft-1])
			min := dpMaxLeft
			if min > height[pLeft] {
				sum += min - height[pLeft]
			}
			pLeft++
		} else {
			dpMaxRight = max(dpMaxRight, height[pRight+1])
			min := dpMaxRight
			if min > height[pRight] {
				sum += min - height[pRight]
			}
			pRight--
		}
	}
	return sum
}

//method5: 栈
//用栈保存每堵墙
//1. 当前高度小于等于栈顶高度，入栈，指针后移
//2. 当前高度大于栈顶高度，出栈，计算当前墙与栈顶墙之间的水，继续判断当前墙与新的栈顶的关系
//O(n), O(n)
func stackTrap(height []int) int {
	length := len(height)
	if length <= 2 {
		return 0
	}

	sum := 0
	var stack []int
	for i := 0; i < length; i++ {
		for len(stack) > 0 && height[i] > height[stack[len(stack)-1]] {
			cur := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			if len(stack) <= 0 {
				break
			}
			dis := i - stack[len(stack)-1] - 1
			h := min(height[stack[len(stack)-1]], height[i]) - height[cur]
			sum += h * dis
		}
		stack = append(stack, i)
	}
	return sum
}

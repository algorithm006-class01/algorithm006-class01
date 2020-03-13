//https://leetcode-cn.com/problems/maximum-product-subarray/description/
package max_product_subarray_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestMaxProductSubarray(t *testing.T) {
	t.Log("Maximum Product Subarray: DP")

	nums1 := []int{2, 3, -2, 4}
	nums2 := []int{-2, 0, -1}
	nums3 := []int{2, -5, -2, -4, 3}
	assert.Equal(t, 6, maxProduct(nums1))
	assert.Equal(t, 0, maxProduct(nums2))
	assert.Equal(t, 24, maxProduct(nums3))
	assert.Equal(t, 6, method1(nums1))
	assert.Equal(t, 0, method1(nums2))
	assert.Equal(t, 24, method1(nums3))
	assert.Equal(t, 6, method2(nums1))
	assert.Equal(t, 0, method2(nums2))
	assert.Equal(t, 24, method2(nums3))
}

func maxProduct(nums []int) int {
	return method2(nums)
}

func method1(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	//dp状态定义：到当前位置，最大值、最小值
	//每次递推只需要和前一次递推的结果比较，所以第一维只需要长度为2
	//第二维:0表示最大值，1表示最小值
	var dp [2][2]int
	//dp初始值：第一个元素
	//如果就只有一个元素，即使是负值，则 最大、最小、结果 都是这个值
	dp[0][0], dp[0][1] = nums[0], nums[0]
	res := nums[0]

	for i := 1; i < len(nums); i++ {
		//x,y 以 (1,0), (0,1), (1,0) ... 轮转滚动
		x, y := i%2, (i-1)%2
		//x,y滚动：这一次是1存储，0运算；下一次就是0存储，上一次存储的1参与运算
		//与当前值进行比较，因为 最大、最小、本身 之间还要比较出个大小
		//而不需要去判断当前值为正还是为负
		dp[x][0] = max3(dp[y][0]*nums[i], dp[y][1]*nums[i], nums[i])
		dp[x][1] = min3(dp[y][0]*nums[i], dp[y][1]*nums[i], nums[i])
		//dp最终值：当前值 与 过程中比较得到的最大值 的较大值
		res = max2(res, dp[x][0])
	}

	return res
}

func method2(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	curMax, curMin, res := nums[0], nums[0], nums[0]

	for i := 1; i < len(nums); i++ {
		curMax, curMin = max3(curMax*nums[i], curMin*nums[i], nums[i]), min3(curMax*nums[i], curMin*nums[i], nums[i])
		res = max2(res, curMax)
	}

	return res
}

func max2(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func max3(a, b, c int) int {
	max := 0
	if a > b {
		max = a
	} else {
		max = b
	}
	if c > max {
		max = c
	}
	return max
}

func min3(a, b, c int) int {
	min := 0
	if a < b {
		min = a
	} else {
		min = b
	}
	if c < min {
		min = c
	}
	return min
}

//https://leetcode-cn.com/problems/longest-increasing-subsequence/
package lis_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestLIS(t *testing.T) {
	t.Log("Longest Increasing Subsequence")
	nums := []int{10, 9, 2, 5, 3, 7, 101, 18}
	assert.Equal(t, 4, lengthOfLIS(nums))
	assert.Equal(t, 4, dpLIS(nums))
	assert.Equal(t, 4, bsLIS(nums))
}

func lengthOfLIS(nums []int) int {
	return bsLIS(nums)
}

//method1: DP
//TC: O(n^2), SC: O(n)
func dpLIS(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	//状态定义：dp[i], 以当前第i个数结尾的LIS的长度
	//初始值：如果当前值就为最小值，则包含当前值的初始值为1 - 需要初始化，否则就是0
	//最终结果：最优的可能并不包含第i个数，所以要取最大值 - 无需记录，每次遍历i比较更新即可
	dp := make([]int, len(nums))
	for i := range dp {
		dp[i] = 1
	}
	length := 1 //最大长度

	for i := 1; i < len(nums); i++ {
		for j := 0; j < i; j++ { //遍历i前面的元素
			if nums[i] > nums[j] { //包含当前值i，且上升序列
				//状态方程：dp[i or j]记录的是包含当前值的最大长度，与i左边的每一个这样的值+1比较取较大值
				dp[i] = max(dp[i], dp[j]+1)
			}
		}
		length = max(length, dp[i]) //无需记录，每次遍历i比较更新即可
	}

	return length
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

//method2: Binary Search Lower Bound
//Go no standard library for Binary Search.
//TC: O(nlogn), SC: O(n)
func bsLIS(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	lis := make([]int, 0, len(nums)) //lis数组/切片用于存储上升子序列

	for _, v := range nums {
		lb := lowerBound(lis, v) //在长度为length的有序数组中，二分查找最小较大值
		//新的元素v比数组lis中元素都大，则左边界lb就是数组长度len(lis)，则append到最后
		//否则，即新的元素v比lis中有的元素小，找到比它大的最小值(左边界)后，替换掉
		if lb == len(lis) {
			lis = append(lis, v)
		} else {
			lis[lb] = v
		}
	}
	return len(lis)
}

func lowerBound(lis []int, v int) int {
	low, high := 0, len(lis)-1
	for low <= high {
		mid := low + (high-low)/2
		if v == lis[mid] {
			return mid
		} else if v < lis[mid] {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	//返回最小的较大值
	return low
}

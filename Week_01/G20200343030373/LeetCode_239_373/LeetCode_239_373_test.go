//https://leetcode-cn.com/problems/sliding-window-maximum/
package sliding_window_maximum_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestDeque(t *testing.T) {
	t.Log("Sliding Window Maximum - Deque")

	nums := []int{1, 3, -1, -3, 5, 3, 6, 7}
	k := 3
	expect := []int{3, 3, 5, 5, 6, 7}
	assert.Equal(t, expect, maxSlidingWindow(nums, k))
}

func maxSlidingWindow(nums []int, k int) []int {
	//追求严谨
	if len(nums) == 0 || len(nums) < k {
		return nums
	}

	//既然k固定，就定义好slice的最大容量
	window := make([]int, 0, k)
	result := make([]int, 0, len(nums)-k+1)

	for index, value := range nums {
		//3.1.处理：维护其最大长度为k
		//index>=k，遍历k次后，如果再append，窗口长度就会超过k
		//window中存储的是索引，如果满了（第一个索引window[0]比当前索引index之间小了k), 则将最左侧元素切去
		//举例：{5,4,3}, 下一个value是2，需要将5从左侧移除，以保持长度
		if index >= k && window[0] <= index-k {
			window = window[1:]
		}

		//3.2.处理:保证每遍历一次后第一个元素值最大，循环处理
		//len(window)>0, 仅第一次index=0时不处理，之后保证window中肯定有至少一个最大值
		//从window切片的最后一个元素对应的数值开始比较，如果比当前遍历的数值小，则切去，之后会append当前遍历的数值
		//如果仅剩一个，也可切去，然后再append
		//举例：{1,2,3}, 下一个value是4，需要将1，2，3都移除，在下一步将4append上
		for len(window) > 0 && nums[window[len(window)-1]] < value {
			window = window[:len(window)-1]
		}

		//1.遍历并将下标注入双端队列
		//之前要有条件处理：维护其长度最大为k；保证每遍历一次后第一个元素值最大
		//之后当足够k个时没遍历一次保存一次结果，存储的是下标，因此能快速定位到元素
		window = append(window, index)

		//2. 当index等于k-1开始，产生结果，双端队列新的头总是当前窗口中最大的那个数
		if index >= k-1 {
			result = append(result, nums[window[0]])
		}
	}
	return result
}

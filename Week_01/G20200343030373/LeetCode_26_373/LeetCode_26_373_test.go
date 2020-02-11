//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
package remove_duplicates_from_sorted_array_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestArray(t *testing.T) {
	t.Log("Array: Remove Duplicates from Sorted Array")

	nums1 := []int{1, 1, 2}
	expect1 := []int{1, 2}
	assert.Equal(t, expect1, nums1[:removeDuplicates(nums1)])
	nums1 = []int{1, 1, 2}
	assert.Equal(t, expect1, nums1[:doublePointer(nums1)])
	nums1 = []int{1, 1, 2}
	assert.Equal(t, expect1, nums1[:reverseTraversal(nums1)])

	nums2 := []int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
	expect2 := []int{0, 1, 2, 3, 4}
	assert.Equal(t, expect2, nums2[:removeDuplicates(nums2)])
	nums2 = []int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
	assert.Equal(t, expect2, nums2[:doublePointer(nums2)])
	nums2 = []int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
	assert.Equal(t, expect2, nums2[:reverseTraversal(nums2)])
}

func removeDuplicates(nums []int) int {
	//Best
	return doublePointer(nums)
}

//快慢指针
//快慢指针初始值相等，快指针先遍历，不相等时，慢指针右移一个后赋值
//最终返回个数，慢指针从零开始，所以加一
func doublePointer(nums []int) int {
	fast, slow := 0, 0
	for ; fast < len(nums); fast++ {
		if nums[slow] != nums[fast] {
			slow++
			nums[slow] = nums[fast]
		}
	}
	return slow + 1
}

//反向遍历
//从最后一个元素遍历到第二个元素
//如果后一个元素i与前一个元素i-1相等，则
//切片操作，将后一个元素i从切片中间拔除
//切片重复操作，最坏O(n^2)，劣于双指针方法
func reverseTraversal(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	for i := len(nums) - 1; i >= 1; i-- {
		if nums[i] == nums[i-1] {
			nums = append(nums[:i], nums[i+1:]...)
		}
	}
	return len(nums)
}

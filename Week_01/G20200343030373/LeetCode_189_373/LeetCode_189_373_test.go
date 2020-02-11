//https://leetcode-cn.com/problems/rotate-array/
package rotate_array_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestRotateArray(t *testing.T) {
	t.Log("Rotate Array")

	nums1 := []int{1, 2, 3, 4, 5, 6, 7}
	expect1 := []int{5, 6, 7, 1, 2, 3, 4}
	rotate(nums1, 3)
	assert.Equal(t, expect1, nums1)

	nums2 := []int{1, 2}
	expect2 := []int{2, 1}
	rotate(nums2, 3)
	assert.Equal(t, expect2, nums2)

	nums3 := []int{-1}
	expect3 := nums3
	rotate(nums3, 2)
	assert.Equal(t, expect3, nums3)
}

func rotate(nums []int, k int) {
	//Best
	reverseRotate(nums, k)
}

//暴力反转
//将最后一个元素移动到第一位，移动k次
//TC:O(kn), SC:O(1) -  AC but Not Good
func bruteRotate(nums []int, k int) {
	length := len(nums)
	k %= length //k为非负数，取余后为最后需要移动的步数

	for i := 0; i < k; i++ {
		//将最后一个元素移动到首位
		//方法：取数组最后一个元素，遍历一遍数组，与最后一个元素进行交换
		end := nums[length-1]
		for j := 0; j < length; j++ {
			nums[j], end = end, nums[j]
		}
	}
}

//切片分割
//取后k个作为切片的初始，取前面的逐个累加到其后 - 直接得到结果
//题目要求在数组原地修改，所以就将结果直接复制进去
//TC:O(n), SC:O(n), not O(1) - AC but Not Good
func sliceRotate(nums []int, k int) {
	length := len(nums)
	k %= length

	res := append(nums[length-k:], nums[:length-k]...)
	nums = append(nums[:0], res...)
}

//多次反转
//先将所有元素进行反转
//将前k个反转恢复，k个是0～k-1，切片的右边是[:k]
//将之后的反转恢复
//TC:O(n), SC:O(1), Good
func reverseRotate(nums []int, k int) {
	k %= len(nums)
	reverse(nums)
	reverse(nums[:k])
	reverse(nums[k:])
}

//反转数组
//左右夹逼
//左右交换
func reverse(nums []int) {
	for i, j := 0, len(nums)-1; i < j; i, j = i+1, j-1 {
		nums[i], nums[j] = nums[j], nums[i]
	}
}

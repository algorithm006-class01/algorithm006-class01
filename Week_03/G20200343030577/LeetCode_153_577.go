package leetcode

/*
 * @lc app=leetcode.cn id=153 lang=golang
 *
 * [153] 寻找旋转排序数组中的最小值
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (50.18%)
 * Likes:    143
 * Dislikes: 0
 * Total Accepted:    33.7K
 * Total Submissions: 67.2K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7]  可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 */

// create time: 2020-02-29 23:28
// @lc code=start
func findMin(nums []int) int {
	return findMin1(nums)
	// return findMin2(nums)
}

// 通过二分法查找最大值间接找到最小值
func findMin1(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	return nums[indexOfMin(nums)]
}

// 通过二分法查找最小值的索引
func indexOfMin(nums []int) int {
	if len(nums) <= 1 {
		return 0
	}
	if len(nums) == 2 {
		if nums[0] > nums[1] {
			return 1
		}
		return 0
	}

	lo, hi := 0, len(nums)-1
	for lo < hi-1 {
		mid := lo + (hi-lo)/2
		if nums[mid] > nums[hi] {
			lo = mid
			continue
		}

		if nums[mid] <= nums[lo] {
			hi = mid
			continue
		}
		return 0
	}
	return hi
}

// 二分法直接查找最小值
func findMin2(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	lo, hi := 0, len(nums)-1
	for lo < hi {
		mid := lo + (hi-lo)/2
		if nums[mid] > nums[hi] {
			lo = mid + 1
		} else {
			hi = mid
		}
	}
	return nums[lo]
}

// @lc code=end

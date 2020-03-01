/* https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 33. 搜索旋转排序数组
*/
package leetcode

func search(nums []int, target int) int {
	start, end := 0, len(nums)-1
	for start <= end {
		mid := (start + end) / 2
		if nums[mid] == target {
			return mid
		} else if targetInLeft(nums, start, mid, end, target) {
			end = mid - 1
		} else {
			start = mid + 1
		}
	}
	return -1
}

func targetInLeft(nums []int, start, mid, end, target int) bool {
	if nums[start] <= nums[mid] {
		return target <= nums[mid] && nums[start] <= target
	}
	return !(target <= nums[end] && nums[mid] <= target)
}

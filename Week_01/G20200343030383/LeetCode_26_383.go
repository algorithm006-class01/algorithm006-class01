// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
package leetcode

func removeDuplicates(nums []int) int {
	var delCount int
	for i := 1; i < len(nums); i++ {
		if nums[i] == nums[i-1] {
			delCount++
		} else if delCount > 0 {
			nums[i-delCount] = nums[i]
		}
	}
	return len(nums) - delCount
}

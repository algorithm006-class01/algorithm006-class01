/*
 * @lc app=leetcode.cn id=283 lang=golang
 *
 * [283] 移动零
 */

// @lc code=start
func moveZeroes(nums []int)  {
	j := 0
	for i := 0; i < len(nums); i++ {
		if nums[i]!=0 {
			if i != j{
				noZero := nums[i]
				nums[i] = nums[j]
				nums[j] = noZero
			}
			j++
		}
	}
}
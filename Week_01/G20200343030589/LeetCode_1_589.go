/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	result := []int{0,0}
    for i := 0; i < len(nums); i++ {
		isResult := false
		temp := target - nums[i]
		for j := 0; j < len(nums); j++ {
			if (temp == nums[j] && i != j){
				result[0]=i
				result[1]=j
				isResult = true
				break
			}
		}
		if isResult{
			break
		}
	}
	return result
}
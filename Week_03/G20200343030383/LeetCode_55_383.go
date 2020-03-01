/*
 * https://leetcode-cn.com/problems/jump-game/submissions/
 * 55. 跳跃游戏
 */
package leetcode

func canJump(nums []int) bool {
	point := len(nums) - 1
	for i := point - 1; i >= 0; i-- {
		if nums[i]+i >= point {
			point = i
		}
	}
	return point == 0
}

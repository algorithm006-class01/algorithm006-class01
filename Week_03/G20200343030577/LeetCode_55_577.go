package leetcode

/*
 * @lc app=leetcode.cn id=55 lang=golang
 *
 * [55] 跳跃游戏
 *
 * https://leetcode-cn.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (37.94%)
 * Likes:    481
 * Dislikes: 0
 * Total Accepted:    64.1K
 * Total Submissions: 167.9K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 *
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 *
 */

// create time: 2020-03-01 14:37
// @lc code=start
func canJump(nums []int) bool {
	// return canJumpUseBack(nums)
	// return canJumpUseGreedy(nums)
	return canJumpUseGreedy2(nums)
}

// 通过回溯+记录位置状态
func canJumpUseBack(nums []int) bool {
	if len(nums) <= 1 {
		return true
	}

	var flag bool
	var jump func(cur,end int) int
	badIndex := make([]int,len(nums))
	jump = func(cur,end int) int{
		if flag {
			return 0
		}

		if cur >= end {
			flag = true
			return 0
		}

		if badIndex[cur] == 1{
			return 1
		}
		
		
		if nums[cur] <= 0 {
			return 1
		}

		failed := 0
		for step := nums[cur];step > 0;step-- {
			failed += jump(cur+step,end)
		}
		if failed == nums[cur]{
			badIndex[cur] = 1
			return 1
		}
		return 0
	}
	jump(0,len(nums)-1)
	return flag
}

// 从后向前的贪心算法
func canJumpUseGreedy(nums []int) bool {
   goodIndex := len(nums)-1
   for i := len(nums)-1;i>=0;i--{
	   if nums[i]+i >= goodIndex{
		   goodIndex = i
	   }
   }
   return goodIndex <= 0
}

// 从前向后的贪心算法
func canJumpUseGreedy2(nums []int) bool {
  maxReached := 0
  for i := 0;i<len(nums) && 
  i <= maxReached &&
   maxReached < len(nums)-1;i++{
      if nums[i] + i > maxReached {
		  maxReached = nums[i] + i
	  }
  }
  return maxReached >= len(nums)-1
}

// @lc code=end

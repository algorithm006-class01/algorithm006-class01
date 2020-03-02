/*
 * @lc app=leetcode.cn id=45 lang=golang
 *
 * [45] 跳跃游戏 II
 *
 * https://leetcode-cn.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (33.06%)
 * Likes:    374
 * Dislikes: 0
 * Total Accepted:    31.6K
 * Total Submissions: 95.1K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 示例:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 
 * 
 * 说明:
 * 
 * 假设你总是可以到达数组的最后一个位置。
 * 
 */

// @lc code=start
class Solution {
    func jump(_ nums: [Int]) -> Int {

    }

    // 回溯遍历
    func jump0(_ nums: [Int]) -> Int {
        
        var minTimes = 0
        func jump(_ start: Int, _ times: Int) {
          if start + nums[start] >= nums.count - 1 {
            minTimes = min(minTimes, times)
            return
          }
          var p = nums[start]
          while p > 0 {
            jump(start+p, times+1)
            p -= 1
          }
        }
    }

    //
    func jump1(_ nums: [Int]) -> Int {

    }
}
// @lc code=end


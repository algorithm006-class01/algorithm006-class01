/*
 * @lc app=leetcode.cn id=55 lang=golang
 *
 * [55] 跳跃游戏
 *
 * https://leetcode-cn.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (38.00%)
 * Likes:    476
 * Dislikes: 0
 * Total Accepted:    62.6K
 * Total Submissions: 164.1K
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

// @lc code=start
class Solution {
    func canJump(_ nums: [Int]) -> Bool {

    }

    // 回溯法（超时）O(2^n)
    func canJump0(_ nums: [Int]) -> Bool {

      func jump(_ i: Int) -> Bool {
          if i == nums.count - 1 {return true}
          if i >= nums.count {return false}
          let val = nums[i]
          if val == 0 {return false}
          for j in 1...val {
              if jump(i + j) {return true}
          }
          return false
      }
      return jump(0)
    }

    // 回溯法 + 记忆表 O(n^2)（还是超时，那自底向上的动态规划也会超时咯）
    func canJump00(_ nums: [Int]) -> Bool {
        var memo = Array(repeating: 0, count: nums.count)
        memo[nums.count-1] = 2
        func jump00(_ i: Int) -> Bool {
            if memo[i] != 0 {return memo[i] == 2 ? true : false}
            let furthestJump = min(i + nums[i], nums.count - 1)
            var j = furthestJump
            while j > i {
                if jump00(j) {memo[j] = 2; return true}
                j -= 1
            }
            memo[i] = 1
            return false
        }
        return jump00(0)
    }

    // 自底向上的动态规划 O(n^2)（没有超时）
    func canJump01(_ nums: [Int]) -> Bool {
        var memo = Array(repeating: 0, count: nums.count)
        memo[nums.count-1] = 2
        for i in stride(from: nums.count - 2, through: 0, by: -1) {
            let furthestJump = min(i + nums[i], nums.count - 1)
            var j = i + 1
            while j <= furthestJump {
                if memo[j] == 2 {
                    memo[i] = 2
                    break
                }
                j += 1
            }
        }
        return memo[0] == 2
    }

    // 贪心算法
    func canJump1(_ nums: [Int]) -> Bool {
        var i = 0, k = 0
        while i < nums.count {
            if i > k {return false}
            k = max(k, i + nums[i])
            i += 1
        }
        return true
    }

    func canJump2(_ nums: [Int]) -> Bool {
        if nums.count > 1 {
            var p = nums.count - 1
            var i = p
            while i >= 0 {
                if i + nums[i] > p {
                    p = i
                }
                i -= 1
            }
            return p == 0
        } else {
            return true
        }
    }
}
// @lc code=end


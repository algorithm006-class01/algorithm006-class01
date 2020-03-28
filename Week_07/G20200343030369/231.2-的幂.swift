/*
 * @lc app=leetcode.cn id=231 lang=swift
 *
 * [231] 2的幂
 *
 * https://leetcode-cn.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (47.53%)
 * Likes:    175
 * Dislikes: 0
 * Total Accepted:    51.7K
 * Total Submissions: 108K
 * Testcase Example:  '1'
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * 
 * 示例 2:
 * 
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * 
 * 示例 3:
 * 
 * 输入: 218
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    func isPowerOfTwo(_ n: Int) -> Bool {

    }

    func isPowerOfTwoNormal(_ n: Int) -> Bool {
        guard n != 0 else {return false}
        var n = n
        while n % 2 == 0 {
            n /= 2
        }
        return n == 1
    }

    // -n = ~n+1
    // n & -n 表示获取 n 最右边的 1
    // 如果 n 是 2 的幂，那 n 中只有一位的 1
    // 则 n & (-n) 取最右边一位后应该跟 n 相等，这样才是 2 的幂
    func isPowerOfTwoBits(_ n: Int) -> Bool {
        guard n != 0 else {return false}
        let n = Int64(n)
        return n & (-n) == n
    }

    func isPowerOfTwoBits2(_ n: Int) -> Bool {
        guard n != 0 else {return false}
        let n = Int64(n)
        return n & (n-1) == 0
    }

}
// @lc code=end


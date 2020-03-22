/*
 * @lc app=leetcode.cn id=153 lang=golang
 *
 * [153] 寻找旋转排序数组中的最小值
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (50.19%)
 * Likes:    143
 * Dislikes: 0
 * Total Accepted:    33.8K
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

// @lc code=start
class Solution {
    func findMin(_ nums: [Int]) -> Int {

    }

    func findMin0(_ nums: [Int]) -> Int {
      var left = 0, right = nums.count - 1
      if nums[right] >= nums[left] {return nums[left]}
      while left <= right {
        let mid = left + (right - left) / 2
        if nums[mid] > nums[mid+1] {
          return nums[mid+1]
        } else {
          if nums[mid] < nums[left] {
            right = mid - 1
          } else {
            left = mid + 1
          }
        }
      }
      return 0
    }
}
// @lc code=end


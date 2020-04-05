// 题目: 最长上升子序列
/**
 * 题目描述：
给定一个无序的整数数组，找到其中最长上升子序列的长度。

 */

 // 解题语言: javaScript

 // 解题
 /**
  * @param {number[]} nums [1,4,3,4,2]
  * @return {number}
  */
 var lengthOfLIS = function(nums) {
     let n = nums.length
     if (n == 0) {return 0}
     let dp = new Array(n).fill(1)
     let max = 0
     for (let i = 0; i < n; i++) {
         for (let j = 0; j < i; j++) {
             if (nums[j] < nums[i]) {
                 dp[i] = Math.max(dp[i], dp[j] + 1)
             }
         }
         max = Math.max(max, dp[i])
     }
     return max
 }
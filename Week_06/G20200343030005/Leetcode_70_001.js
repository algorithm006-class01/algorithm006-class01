// 70. 爬楼梯 https://leetcode-cn.com/problems/climbing-stairs/

/**
 * @param {number} n
 * @return {number}
 */
// 方法一：暴力法
var climbStairs = function(n) {
  return climb_Stairs(0, n);
};
function climb_Stairs(i, n) {
  if (i > n) {
    return 0;
  }
  if (i == n) {
    return 1;
  }
  return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
}
// 方法三：动态规划
/* var climbStairs = function(n) {
  if (n == 1) {
    return 1;
  }
  var dp = new Array(n + 1);
  dp[1] = 1;
  dp[2] = 2;
  for (var i = 3; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2];
  }
  return dp[n];
}; */

// 方法六：斐波那契公式
/* var climbStairs = function(n) {
  const sqrt5 = Math.sqrt(5);
  const fibn =
    Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
  return Math.round(fibn / sqrt5);
}; */
console.log(climbStairs(7));

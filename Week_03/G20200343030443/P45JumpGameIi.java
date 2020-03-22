//Java：跳跃游戏 II
public class P45JumpGameIi {
  
  public static void main(String[] args) {
    Solution solution = new P45JumpGameIi().new Solution();
    // TO TEST
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    
    public int jump(int[] nums) {
      int minStep = 0, index = 0;
      while (index < nums.length - 1) {
        if (nums[index] + index >= nums.length - 1) {  //最后一步正好到终点或超过终点
          return minStep + 1;
        }
        int maxStep = nums[index];
        for (int i = 1; i < nums[index]; i++) { //一步最优解 即 当前步长+下一步步长 最大
          if (maxStep + nums[index + maxStep] < i + nums[index + i]) {
            maxStep = i;
          }
        }
        index += maxStep;
        minStep++;
      }
      return minStep;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}
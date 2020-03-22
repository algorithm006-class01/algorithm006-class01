//Java：柠檬水找零
public class P860LemonadeChange {
  
  public static void main(String[] args) {
    Solution solution = new P860LemonadeChange().new Solution();
    // TO TEST
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    
    public boolean lemonadeChange(int[] bills) { //傻瓜式写法
      int fiveSum = 0, tenSum = 0;
      for (int i = 0; i < bills.length; i++) {
        if (bills[i] == 5) {
          fiveSum += 5;
        } else if (bills[i] == 10) {
          if (fiveSum == 0) {
            return false;
          }
          fiveSum -= 5;
          tenSum += 10;
        } else if (bills[i] == 20) {
          if (fiveSum + tenSum < 15 || fiveSum == 0) {
            return false;
          }
          if (tenSum >= 10) {
            tenSum -= 10;
            fiveSum -= 5;
          } else {
            fiveSum -= 15;
          }
        }
      }
      return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}
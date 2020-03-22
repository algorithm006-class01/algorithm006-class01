/*
 * @lc app=leetcode id=860 lang=java
 *
 * [860] Lemonade Change
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        // int twenties = 0; 不用跟踪20的数量，因为退款时不会用到
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    fives++;
                    break;
                case 10:
                    tens++;
                    fives--;
                    break;
                case 20:
                    if (tens > 0 && fives > 0) {
                        tens--;
                        fives--;
                    } else {
                        fives -= 3;
                    }
                    break;
            }
            if (fives < 0 || tens < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

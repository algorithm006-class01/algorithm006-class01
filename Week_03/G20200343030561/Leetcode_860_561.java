/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int b: bills) {
            if (b == 5) five ++;
            else if (b == 10) {five --; ten ++;}
            else if (ten > 0) {five --; ten --;} // b==20&&ten>0
            else five -= 3; // b==20&&ten<=0
            if(five<0) return false;
        }
        return true;
    }    
}
/*
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int b : bills) {
            switch(b){
                case 5:
                    five ++;
                    break;
                case 10:
                    if (five == 0) return false;
                    five --;
                    ten ++;
                    break;
                case 20:
                    if (five > 0 && ten > 0) {
                        five --;
                        ten --;
                    } else if ( five > 2) {
                        five -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
*/
// @lc code=end


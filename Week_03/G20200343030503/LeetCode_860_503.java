/**
 * 
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill: bills) {
            if (bill == 5) { //如果顾客给的正好是5元,直接five++
                five++;
            } else if (bill == 10) {
                if (five == 0) return false; //如果顾客给的是10元,看下手里有没有5元
                five--;//有的话需要给客户找5元
                ten++;//同时自己手里有一个10元
            } else if (bill == 20) { //如果客户给的是20元
                if (ten > 0 && five >0) { //情况1就是给顾客找一个10元+一个5元
                    ten--;
                    five--;
                } else if (five > 3) {//情况2就是给顾客找三个5元
                    five -= 3;
                } else {//找不开
                    return false;
                }
            }
        }
        return true;
    }
}
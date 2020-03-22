package G20200343030015.week_03;

/**
 * 860. 柠檬水找零
 * site:: https://leetcode-cn.com/problems/lemonade-change/description/
 * Created by majiancheng on 2020/3/2.
 */
public class LeetCode_860_015 {
    //注意点，当金额为20时，两种情况是满足的
    //1. 1个10元， 1个5元。
    //2. 3个5元。
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int bill : bills) {
            if (bill == 5) five ++;
            else if(bill == 10) {five --; ten++;}
            else if(ten > 0) {ten --; five --;}
            else five = five - 3;
            if(five < 0) return false;
        }

        return true;
    }
}

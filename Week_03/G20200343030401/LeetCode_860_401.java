// 题目连接: https://leetcode-cn.com/problems/lemonade-change/
class Solution {
    /**
     * 方法1: 暴力求解法
     * 时间复杂度: O(N), 其中N是bills的长度
     * 空间复杂度: O(1)
     */
    public boolean lemonadeChange1(int[] bills) {
        int five = 0, ten = 0;
        for (int bill: bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 方法1: 贪心算法
     * 时间复杂度: O(N)
     * 空间复杂度: O(1), 没有用到额外空间
     */
    public boolean lemonadeChange2(int[] bills) {
        int fives = 0, tens = 0; 
        if (bills.length < 1) return true;
        if (bills[0] != 5) return false;
        for (int index = 0; index < bills.length; ++index) {
            if (bills[index] == 5) 
                fives++;
            else if (bills[index] == 10) {
                if (fives < 1)
                    return false;
                fives--;
                tens++;
            } else {
                if (tens > 0 && fives > 0) {
                    tens--;
                    fives--;
                } else if (fives > 2) 
                    fives -= 3;
                else return false;
            }
        }
        return true;
    }
}
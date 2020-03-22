class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            // 顾客给了 5 美元
            if (bill == 5) five++;
            // 顾客给了 10 美元
            else if (bill == 10) {
                // 自己手里没有 5 美元的话，就不能换钱
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                // 顾客给了 20 美元
                // 如果手里正好有 5 美元和 10 美元就换给顾客
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                // 如果手里有 3 个以上的 5 美元，正好换给顾客
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

/**
* 这道题就是按照题目正常思路一步一步推导的
* 模拟真实的场景
*/
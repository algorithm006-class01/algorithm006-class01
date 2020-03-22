class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) { // 支付5元
                five++;
            } else if (bill == 10) { // 支付10元
                if (five == 0) return false;
                five--;
                ten++;
            } else { // 支付20元
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3){
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
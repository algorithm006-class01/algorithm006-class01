class Solution {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 10, 5, 20, 5, 20}));
    }


    /**
     * 如果是20元，先找10+5体现了贪心算法
     *
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five > 2) {
                    five = five - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int key : bills) {
            if (key == 5) {
                five++;
            }
            else if (key == 10) {
                five--;
                ten++;
            }
            else if (ten > 0){
                ten--;
                five--;
            }
            else five -= 3;
            if (five < 0) {
                return false;
            }
        }
        return true;
    }
}
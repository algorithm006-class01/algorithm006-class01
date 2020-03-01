class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }
        if (bills[0] > 5) {
            return false;
        }
        int[] box = new int[2];
        for (int index = 0; index < bills.length; index ++) {
            if (bills[index] == 5) {
                box[0] ++;
            } else if (bills[index] == 10) {
                if (box[0] == 0) {
                    return false;
                }
                box[1] ++;
                box[0] --;
            } else {
                if (box[1] > 0){
                    box[1] --;
                    box[0] --;
                } else {
                    box[0] -= 3;
                }
                if (box[0] < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
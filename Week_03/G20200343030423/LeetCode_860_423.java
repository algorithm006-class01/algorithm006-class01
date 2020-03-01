public class LeetCode_860_423 {

}

class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        if (bills.length <= 0 || bills[0] != 5) {
            return false;
        }
        int fiveCount = 0;
        int tenCount = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
            } else if (bills[i] == 10) {
                if (fiveCount > 0) {
                    fiveCount--;
                    tenCount++;
                } else {
                    return false;
                }
            } else if  (bills[i] == 20) {
                if (tenCount > 0 && fiveCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else if (fiveCount > 3) {
                    fiveCount = fiveCount-3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

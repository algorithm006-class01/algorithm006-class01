public class Solution_860 {
    public boolean lemonadeChange(int[] bills) {
        int fiveIndex = 0;
        int tenIndex = 0;
        for (int index = 0; index < bills.length; index++) {
            if (bills[index] == 10) {
                if (fiveIndex == 0) {
                    return false;
                }
                fiveIndex--;
                tenIndex++;
            } else if (bills[index] == 5) {
                fiveIndex++;
            } else {
                if (tenIndex > 0 && fiveIndex > 0) {
                    tenIndex--;
                    fiveIndex--;
                } else if (fiveIndex >= 3) {
                    fiveIndex -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

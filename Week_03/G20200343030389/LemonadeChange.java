package follow.ice.phenix.leecode.week03;

/**
 * 柠檬水找零
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveCount++;
            } else if (bill == 10) {
                if (fiveCount >= 1) {
                    fiveCount--;
                    tenCount++;
                } else {
                    return false;
                }
            } else {
                if (fiveCount >= 1 && tenCount >= 1) {
                    fiveCount--;
                    tenCount--;
                } else if (fiveCount >= 3) {
                    fiveCount = fiveCount - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

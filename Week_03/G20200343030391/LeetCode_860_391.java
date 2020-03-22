package G20200343030391;

public class LeetCode_860_391 {

    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        boolean b = new LeetCode_860_391().lemonadeChange(bills);
        System.out.println(b);

    }

    /**
     * 贪心算法
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:
                    five++;
                    break;
                case 10:
                    if (five > 0) {
                        five--;
                        ten++;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (five > 0 && ten > 0) {
                        five--;
                        ten--;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}

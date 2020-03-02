package Week_03.G20200343030395;

public class LeetCode_1_395 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            //5块钱，不用找，获得5块钱零钱
            if(bill == 5) {
                five++;
            } else if (bill == 10) {
                //10块，找5块；如果没有5块的，就完犊子了
                if(five == 0) {
                    return false;
                }

                five --;
                ten ++;
            } else {
                //20的，有10+5就找10+5，没有全5，还是没有完犊子
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
}

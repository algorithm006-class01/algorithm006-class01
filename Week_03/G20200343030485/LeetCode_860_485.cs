
public class Solution {
    public bool LemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        for (int i = 0; i < bills.Length; i++) {
            int num = bills[i];
            if (num == 5) {
                count5++;
            }
            else if (num == 10) {
                if (count5 == 0) {
                    return false;
                }

                count5--;
                count10++;
            }
            else if (num == 20) {
                if (count10 > 0 && count5 > 0) {
                    count10--;
                    count5--;
                }
                else if (count5 >= 3) {
                    count5 = count5 - 3;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }
}
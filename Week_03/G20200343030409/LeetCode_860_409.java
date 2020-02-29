/*
    greedy algo, becasue if we have $10, we use combination of $5 & $10 first

    time complexity: O(n) , space complecity: O(1)
*/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {

            if (bill == 5) {
                five++; //$5 number ++
            } else if (bill == 10) { //$10 number ++, and changing $5 back
                five--;
                ten++;

            } else if (ten > 0) { // 20 dollars case, if we have ten coins, use combination of $5 & $10 first
                five--;
                ten--;

            } else {
                five -= 3; //not enough $10, so using 3 $5
            }

            if (five < 0) return false; // in loop, we found not enough change
        }
        return true;
    }
}
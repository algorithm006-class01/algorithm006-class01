/*
    greedy

    time complexity: O(n), space complexity:O(1)
*/
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) { // or add  i+1 < prices.length &&  in if statement
            if (prices[i+1] > prices[i]) { // found next price is bigger, add it to profit
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }
}
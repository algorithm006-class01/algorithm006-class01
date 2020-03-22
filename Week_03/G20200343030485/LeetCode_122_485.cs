public class Solution {
    public int MaxProfit(int[] prices) {
        if (prices.Length == 0) {
            return 0;
        }

        int totalProfit = 0;
        int lastPrice = prices[0];
        for (int i = 1; i < prices.Length; i++) {
            if (prices[i] > lastPrice) {
                totalProfit += prices[i] - lastPrice;
            }

            lastPrice = prices[i];
        }

        return totalProfit;
    }
}
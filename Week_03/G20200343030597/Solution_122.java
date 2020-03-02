public class Solution_122 {
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int index = 0; index < prices.length - 1; index++) {
            if (prices[index] < prices[index + 1]) {
                total += prices[index + 1] - prices[index];
            }
        }
        return total;
    }
}

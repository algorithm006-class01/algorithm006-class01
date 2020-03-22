class Solution {
    public int maxProfit(int[] prices) {
        int count = o;
        for (int index = 0; index < prices.length - 1; index ++) {
            if (prices[index] < prices[index + 1]) {
                count += prices[index + 1] - prices[index];
            }
        }
        return count;
    }
}
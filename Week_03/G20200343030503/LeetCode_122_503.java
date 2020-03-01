class Solution {
    public int maxProfit(int[] prices) {
        int res = 0; //存放最大利润
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            int profit = prices[i+1] - prices[i];
            if (profit > 0) {
                res += profit;
            }
        }
        return res;
    }
}
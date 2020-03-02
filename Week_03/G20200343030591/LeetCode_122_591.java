class Solution {

    /**
     * 贪心
     * 只要出现上涨就抛售获取利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length==0 || prices==null) return 0;
        int profit = 0;
        for (int i=1 ; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

}
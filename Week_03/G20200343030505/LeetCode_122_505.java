class LeetCode_122_505 {
     public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        for (int i=1;i<prices.length;++i) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) {
                maxProfit += tmp;
            }
        }

        return maxProfit;
    }
}
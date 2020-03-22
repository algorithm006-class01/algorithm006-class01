class Solution {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 53, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        int tem = 0;
        for (int i = 1; i < prices.length; i++) {
//            关键：贪心算法思想，后一天大于前一天的收益才加和
            if (prices[i] > prices[i - 1]) {
                tem += prices[i] - prices[i - 1];
            }
        }
        return tem;
    }
}
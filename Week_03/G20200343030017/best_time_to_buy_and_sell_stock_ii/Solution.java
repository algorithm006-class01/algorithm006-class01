package week3.best_time_to_buy_and_sell_stock_ii;

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        boolean buyflag = false;
        for (int n=0;n<prices.length;n++){
            if (buyflag){
                profit=profit+(prices[n]-prices[n-1]);
                buyflag = false;
            }
            if (n<prices.length-1&&(prices[n]>prices[n+1])){
                continue;
            }
            if (n<prices.length-1&&(prices[n]<prices[n+1])){
                buyflag = true;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] nums = {7,6,4,3,1};
        Solution s = new Solution();
        System.out.println(s.maxProfit(nums));
    }
}

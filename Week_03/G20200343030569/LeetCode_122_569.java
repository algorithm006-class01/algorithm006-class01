/*
 * 122. Best Time to Buy and Sell Stock II
 * 买卖股票的最佳时机 II
 */
public class LeetCode_122_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = { 7,1,5,3,6,4 };
		LeetCode_122_569 main = new LeetCode_122_569();
		int result = main.new Solution().maxProfit(data);
		System.out.println( result );

	}

	class Solution {
	    public int maxProfit(int[] prices) {
	    	int profit = 0; 
	    	for ( int i = 1; i < prices.length; i++ ){
	    		if ( prices[i] > prices[i-1] )
	    			profit += prices[i] - prices[i-1];
	    	}
	    	return profit;
	    }
	}
}

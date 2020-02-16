/*
 * 42. Trapping Rain Water
 * 接雨水
 */
public class LeetCode_42_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2,0,2 };
		int n =  (new LeetCode_42_569()).new Solution().trap(nums);
		System.out.println(n);
	}

	class Solution {
		/*
		 * 按行算水量，行数等于高度数组的最大值，但这个算法对于高度高的数组超时，比较垃圾
		 */
	    public int trap(int[] height) {
	    	int water = 0;	    	
	    	int rows = 0;
	    	for (int i:height) {
	    		rows = Math.max(rows, i);
	    	}	    	
	    	//遍历每行
	    	for ( int i = 1; i <= rows; i++ ) {
	    		int rowWater = 0;
	    		int left = -1;
	    		int right = -1;
	    		for ( int j = 0; j < height.length; j++ ) {
	    			if ( height[j] >= i )  {
	    				if ( left < 0 ) { //第一个left
	    					left = j;
	    				}else {
	    					if ( j == left + 1 ) { 
	    						left = j;
	    					}else {
	    						right = j;	    						
	    						rowWater = rowWater + (right - left - 1);
	    						left = right;
	    						right = -1;
	    					}
	    				}
	    			}	    			
	    		}
	    		water += rowWater;
	    	}
	        return water;
	    }
	}
}

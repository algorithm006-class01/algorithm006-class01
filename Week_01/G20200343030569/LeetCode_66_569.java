/*
 * 66. Plus One
 * 加一
 */
public class LeetCode_66_569 {

	public static void main(String[] args) {
		int[] nums = { 4,3,8,9 };
		(new LeetCode_66_569()).new Solution().plusOne(nums);
		for( int i = 0; i < nums.length; i++ ){
			System.out.println(nums[i]);
		}	
	}

	class Solution {
	    public int[] plusOne(int[] digits) {
	    	int carry = 0;
	    	for ( int i = digits.length - 1; i >= 0; i-- ) {
	    		int j = digits[i] + (i == digits.length-1 ? 1 : 0 ) + carry--;
	    		carry =  (j / 10 > 0) ? 1 : 0;
	    		digits[i] = j % 10;
	    	}	    	
	    	if ( carry > 0 ) {
	    		digits = new int[digits.length+1];
	    		digits[0] = 1;
	    	}
	        return digits;
	    }
	}
}

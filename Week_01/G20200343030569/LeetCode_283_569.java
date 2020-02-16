
/*
 * 283. Move Zeroes
 * 移动零
 */
public class LeetCode_283_569 {

	public static void main(String[] args) {
		int[] nums = { 0,1,0,3,12,0 };
		int target = 9;
		(new LeetCode_283_569()).new Solution().moveZeroes(nums);
		for( int i = 0; i < nums.length; i++ ){
			System.out.println(nums[i]);
		}	
	}

	class Solution {
	    public void moveZeroes(int[] nums) {
	    	int validIndex = 0;
	    	for ( int i = 0; i < nums.length; i++ ) {
	    		if ( nums[i] != 0 ) {
	    			nums[validIndex++] = nums[i];
	    			nums[i] = 0;
	    		}
	    	}
	    }
	}
}

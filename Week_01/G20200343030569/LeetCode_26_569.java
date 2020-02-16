/*
 * 26. Remove Duplicates from Sorted Array
 * 删除排序数组中的重复项
 */
public class LeetCode_26_569 {
	public static void main( String[] argv) {
		int[] nums = { 0,0,1,1,1,2,2,3,3,4,4 };
		int n =  (new LeetCode_26_569()).new Solution().removeDuplicates(nums);
		for( int i = 0; i < n; i++ ){
			System.out.println(nums[i]);
		}
	}

	class Solution {
	    public int removeDuplicates(int[] nums) {
	    	if (nums.length <= 1)
	    		return nums.length;
	    	
	    	int validIndex = 1;
	    	int lastNum = nums[0];
	    	for (int i = 1; i < nums.length; i++) {
	    		if (nums[i] != lastNum) {
	    			nums[validIndex++] = nums[i];
	    			lastNum = nums[i];
	    		}
	    	}
	    	return validIndex;
	    }
	}	
}


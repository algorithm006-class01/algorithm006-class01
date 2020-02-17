
/*
 * 189.Rotate Array
 * 旋转数组
 */
public class LeetCode_189_569 {

	public static void main(String[] args) {
		int[] nums = { 1,2,3,4,5,6,7 };
		int k = 4;
		(new LeetCode_189_569()).new Solution().rotate(nums,k);
		for( int i = 0; i < nums.length; i++ ){
			System.out.println(nums[i]);
		}
	}

	class Solution {
	    public void rotate(int[] nums, int k) {
	    	k = k % nums.length;
	    	for (int i = 0, count = 0; count < nums.length; i++) {
	    		int source = i;
	    		int sourceValue = nums[source];
	    		do {
	    			int dest = (source + k) % nums.length;
	    			int temp = nums[dest];
	    			nums[dest] = sourceValue;
	    			source = dest;
	    			sourceValue = temp;
	    			count++;	    			
	    		} while (source != i);
	    	}
	    }
	}
}


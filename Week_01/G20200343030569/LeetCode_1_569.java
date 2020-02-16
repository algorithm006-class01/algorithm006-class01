import java.util.HashMap;
import java.util.Map;

/*
 * 1. Two Sum
 * 两数之和
 */
public class LeetCode_1_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 12,2,7,11,15 };
		int target = 9;
		int[] n =  (new LeetCode_1_569()).new Solution().twoSum(nums, target);
		for( int i = 0; i < n.length; i++ ){
			System.out.println(n[i]);
		}
	}

	class Solution {
	    public int[] twoSum(int[] nums, int target) {
	    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();	    	
	    	for (int i = 0; i < nums.length; i++) {
	    		int want = target - nums[i];
	    		if( map.containsKey(want) ) {
	    			return new int[] { map.get(want), i };
	    		}
	    		map.put(nums[i], i);
	    	}
	        return null;
	    }
	}
}

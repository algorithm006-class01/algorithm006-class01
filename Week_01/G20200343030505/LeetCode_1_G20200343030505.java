/**
 * 
 */

/**
 * @author huangwen05
 *
 * @date:   2020年2月16日 下午8:47:10 
 */
public class LeetCode_1_G20200343030505 {
	   public int[] twoSum(int[] nums, int target) {
	        if(nums == null || nums.length < 2) {
	            return new int[0];
	        }

	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i=0;i<nums.length;++i) {
	            map.put(nums[i], i);
	        }

	        int[] result = new int[2];
	        for(int i=0;i<nums.length;++i) {
	            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
	                result[0] = i;
	                result[1] = map.get(target - nums[i]);
	                break;
	            }
	        }             
	        
	        return result;
	    }
	}
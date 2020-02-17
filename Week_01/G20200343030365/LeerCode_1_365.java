package homework.week_01;

import java.util.HashMap;
import java.util.Map;

public class LeerCode_1_365 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                result[0] = map.get(temp);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
        }
        return null;
    }
}

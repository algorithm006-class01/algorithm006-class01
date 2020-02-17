package jc.demo;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_559 {
    public int[] twoSum(int[] nums, int target) {
        //有且仅有两个数
        int[] subscript = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)&&map.get(temp)!=i){
                subscript[0]=i;
                subscript[1]=map.get(temp);
            }
        }
        return subscript;
    }
}

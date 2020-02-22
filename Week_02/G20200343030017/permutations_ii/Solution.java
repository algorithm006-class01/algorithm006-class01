package week2.permutations_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list =new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int n=0;n<nums.length;n++){
            map.put(n,nums[n]);
        }
        recursion(list,temp,nums,map,map);
        return list;
    }
    public void recursion(List<List<Integer>> list,List<Integer> temp,int[] nums,HashMap<Integer,Integer> map,HashMap<Integer,Integer> tempmap){
        if (temp.size()==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int a=0;a<nums.length;a++){
            if (tempmap.get(nums[a])==-1){
                continue;
            }
            if (temp.contains(nums[a])){
                tempmap.put(nums[a],tempmap.get(nums[a])-1);
            }
            temp.add(nums[a]);
            recursion(list,temp,nums,map,tempmap);
            temp.remove(temp.size()-1);
            tempmap=map;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,2};
        List<List<Integer>> list = s.permuteUnique(nums);
        System.out.println(list.toString());
    }
}

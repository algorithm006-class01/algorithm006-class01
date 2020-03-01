package week2.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list =new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recursion(list,temp,nums);
        return list;
    }
    public void recursion(List<List<Integer>> list,List<Integer> temp,int[] nums){
        if (temp.size()==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int a=0;a<nums.length;a++){
            if (temp.contains(nums[a])){
                continue;
            }
            temp.add(nums[a]);
            recursion(list,temp,nums);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> list = s.permute(nums);
        System.out.println(list.toString());
    }
}

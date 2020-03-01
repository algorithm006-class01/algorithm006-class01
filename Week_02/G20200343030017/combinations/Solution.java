package week2.combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list =new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recursion(list,temp,n,k,1);
        return list;
    }

    public void recursion(List<List<Integer>> list,List<Integer> temp,int n, int k,int begin){
        if (temp.size()==k){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int a=begin;a<=n;a++){
            temp.add(a);
            recursion(list,temp,n,k,a+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> list = s.combine(4,2);
        System.out.println(list.toString());
    }
}

package week6.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        recursion(n,n,"",list);
        return list;
    }
    public void recursion(int left,int right,String temp,List<String> list){
        if (left==0 && right==0){
            list.add(temp);
            return;
        }
        if (left>0){
            recursion(left-1,right,temp+"(",list);
        }
        if (right>0 && right>left){
            recursion(left,right-1,temp+")",list);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(n));
    }
}

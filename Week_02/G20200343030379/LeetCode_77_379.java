package G20200343030379;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

//77. 组合
public class LeetCode_77_379 {
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        findCombinations(n,k,1,new Stack<Integer>());
        return res;
    }

    //回溯算法
    private void findCombinations(int n, int k, int cur, Stack<Integer> stack) {
        if(stack.size()>=k){
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = cur; i <= n; i++) {
            stack.add(i);
            findCombinations(n,k,i+1,stack);
            stack.pop();

        }

    }


    public static void main(String[] args) {

    }
}

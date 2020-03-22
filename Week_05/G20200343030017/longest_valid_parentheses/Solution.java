package week5.longest_valid_parentheses;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        int count = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int n=0;n<s.length();n++){
            if (s.charAt(n)=='('){
                stack.push(n);
            }else{
                if (stack.peek()!=-1 && s.charAt(stack.peek())=='('){
                    stack.pop();
                }else{
                    stack.push(n);
                }
            }
        }
        int len = s.length();
        while(!stack.isEmpty()){
            max = Math.max(max,len-stack.peek()-1);
            len=stack.pop();
        }
        return max;
    }

    public static void main(String[] args) {
        String word = "()(()";
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses(word));
    }
}

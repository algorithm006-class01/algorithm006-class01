package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class leetcode20 {
    public boolean isValid(String s) {
        //通过栈来解决问题
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                char top = stack.empty() ? '#' : stack.pop();
                if (top != map.get(c)){
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

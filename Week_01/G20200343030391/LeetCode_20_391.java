package G20200343030391;

import java.util.HashMap;
import java.util.Stack;

public class LeetCode_20_391 {

    public static void main(String[] args) {
        String s = "()[]{}";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    /**
     * 最近相关性：使用栈先进先出的特性
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if (hashMap.containsKey(charArray[i])) {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.pop() != hashMap.get(charArray[i])) {
                    return false;
                }
            } else {
                stack.push(charArray[i]);
            }
        }
        return stack.isEmpty();
    }
}


/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
// import java.util.regex.*;
// class Solution {
//     public int myAtoi(String str) {
//         Pattern pattern = Pattern.compile("[-+]??[0-9]++");
//         Matcher matcher = pattern.matcher(str.trim());
//         if (matcher.lookingAt()) {
//             String num = str.trim().substring(0, matcher.end());
//             try {
//                 return Integer.parseInt(num);
//             } catch (NumberFormatException e) {
//                 return num.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//             }
//         }
//         return 0;
//     }
// }

// @lc code=start
// @date Apr 3 2020
// @solution dfa
import java.util.HashMap;
class Solution {
    public int myAtoi(String str) {
        Automation dfa = new Automation();
        for (char c : str.toCharArray())
            dfa.set(c);
        return dfa.sign * (int)dfa.num;
    }
    class Automation {
        HashMap<String, String[]> table = new HashMap<>();
        String state = "start";
        int sign = 1;
        long num = 0;
        Automation() {
            table.put("start", new String[]{"start", "signed", "in_number", "end"});
            table.put("signed", new String[]{"end", "end", "in_number", "end"});
            table.put("in_number", new String[]{"end", "end", "in_number", "end"});
            table.put("end", new String[]{"end", "end", "end", "end"});
        }
        String nextState (String state, char c) {
            String[] states = table.get(state);
            if (c == ' ') return states[0];
            if (c == '+' || c == '-') return states[1];
            if (c <='9' && c >= '0') return states[2];
            return states[3];
        }
        void set(char c) {
            state = nextState(state, c);
            if (state == "signed")
                sign = c == '+' ? 1 : -1;
            if (state == "in_number") {
                num = num * 10 + (c - '0');
                if (sign > 0)
                    num = Math.min(num, (long)Integer.MAX_VALUE);
                else
                    num = Math.min(num, -(long)Integer.MIN_VALUE);
            }
        }
    }
}

// @lc code=end


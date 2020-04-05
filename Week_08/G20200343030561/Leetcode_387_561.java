import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
// class Solution {
//     public int firstUniqChar(String s) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (char c: s.toCharArray())
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         int res = 0;
//         for (char c: s.toCharArray()) {
//             if (map.get(c) == 1) return res;
//             res ++;
//         }
//         return -1;
//     }
// }

class Solution {
    public int firstUniqChar(String s) {
        int res = s.length();
        for (int i = 'a'; i <= 'z'; i ++) {
            int start = s.indexOf(i);
            if (start == s.lastIndexOf(i) && start != -1)
                res = Math.min(res, start);
        }
        return res == s.length() ? -1 : res;
    }
}
// @lc code=end


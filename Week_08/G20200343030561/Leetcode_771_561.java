import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=771 lang=java
 *
 * [771] 宝石与石头
 */

// @lc code=start
class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> j = new HashSet<>();
        for (char c : J.toCharArray()) 
            j.add(c);
        int res = 0;
        for (char c : S.toCharArray())
            if (j.contains(c))
                res ++;
        return res;
    }
}
// @lc code=end


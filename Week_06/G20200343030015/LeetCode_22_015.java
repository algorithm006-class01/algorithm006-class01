package G20200343030015.week_06;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by majiancheng on 2020/3/22.
 */

/**
 * 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class LeetCode_22_015 {

    public List<String> generateParenthesis(int n) {
        List<String> strs = new ArrayList<String>();
        helper(strs, "", 0, 0, n);
        return strs;
    }

    public void helper(List<String> strs, String curr, int open, int close, int n) {
        if(curr.length() == n * 2) {
            strs.add(curr);
            return;
        }

        if(open < n) {
            helper(strs, curr + "(", open + 1, close, n);
        }
        if(close < open) {
            helper(strs, curr + ")", open, close + 1, n);
        }
    }

}

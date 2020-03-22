package Week_06.G20200343030395;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_7_395 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backtrack(ans, "", 0, 0, n);

        return ans;
    }

    public void backtrack(List<String> ans, String cur, int left, int right, int max){
        if(cur.length() == max*2) {
            ans.add(cur);
            return;
        }

        //左括号少于长度的时候，可以加左括号
        if(left < max) {
            backtrack(ans, cur+"(", left+1, right, max);
        }
        //右括号少于长度的时候，可以加右括号
        if(right < left) {
            backtrack(ans, cur+")", left, right+1, max);
        }
    }
}

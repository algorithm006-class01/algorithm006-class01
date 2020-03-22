package Week_06;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_022_001 {
    private List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();

        dfs(0, 0, n, "");

        return ans;
    }

    private void dfs(int left, int right, int n, String str) {
        if (left == n && left == right) {
            ans.add(str);

            return;
        }

        if (left < n) {
            dfs(left + 1, right, n, str + "(");
        }

        if (right < left) {
            dfs(left, right + 1, n,str + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_022_001().generateParenthesis(3));
    }
}

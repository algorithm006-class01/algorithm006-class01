package Week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_077_001 {
    private List<List<Integer>> res = new ArrayList<>();

    private void findCombinations(int n, int k, int begin, Stack<Integer> pre) {
        if (pre.size() == k) {
            res.add(new ArrayList<>(pre));

            return;
        }

        for (int i = begin; i <= n; i++) {
            pre.add(i);

            findCombinations(n, k, i + 1, pre);

            pre.pop();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }

        findCombinations(n, k, 1, new Stack<>());

        return res;
    }
}

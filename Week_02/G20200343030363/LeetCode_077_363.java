package cn.geek.week2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月22日 16:28:00
 */
public class LeetCode_077_363 {

    /**
     * Combine list.
     *
     * @param n
     *            the n
     * @param k
     *            the k
     * @return the list
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> selected = new ArrayList<>();
        backtrack(n, k, 1, selected, res);
        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> selected, List<List<Integer>> res) {
        if (selected.size() == k) {
            res.add(new ArrayList<>(selected));
            return;
        }
        for (int i = start; i <= n - (k - selected.size()) + 1; i++) {
            selected.add(i);
            backtrack(n, k, i + 1, selected, res);
            selected.remove(selected.size() - 1);
        }
    }
}

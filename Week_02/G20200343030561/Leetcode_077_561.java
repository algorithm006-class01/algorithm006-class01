import java.util.*;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        helper(new ArrayList<Integer>(), n, k, 1);
        return res;
    }
    private void helper(ArrayList<Integer> kList, int n, int k, int i) {
        if (kList.size() == k) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int v: kList)
                tmp.add(v);
            res.add(tmp);
            return;
        }

        for(int j = i; j <= n; j++) {
            kList.add(j);
            helper(kList, n, k, j+1);
            kList.remove(kList.size() - 1);
        }
    }
}
// @lc code=end


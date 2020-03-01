package com.home.work.week02;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_77_587 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        //回溯算法
        backtrack(1, n, k, new ArrayList<>());
        return res;
    }

    void backtrack(int start, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        //未剪枝前
        // for (int i = start; i <= n; i++) {
        //     list.add(i);
        //     backtrack(i + 1, n, k, list);
        //     list.remove(list.size() - 1);
        // }
        // 剪枝后
        // k - list.size = 还需要多少个数
        // (n - i) ＋ 1 = n中还剩下多少个数
        // 剩下个数是包含i本身的,所以是n-i + 1
        // 如不满足 (n -i) + 1 >= k - list.size 后续操作都是无效的
        // k - list.size + i <= n - i + 1 = i
        // i <= n - (k - list.size) + 1
        //
        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backtrack(i + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }
}

package G20200343030391;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_77_391 {

    public static void main(String[] args) {
        int n = 1;
        int k = 1;
        List<List<Integer>> combine = new LeetCode_77_391().combine(n, k);
        System.out.println(combine);
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 1 || k <= 0 || n < k) {
            return result;
        }
        findCombines(n, k, 1, new Stack<>());
        return result;
    }

    /**
     * 回溯 stack实现回溯功能，保存起点数字
     *
     * @param n
     * @param k
     * @param start
     * @param pre
     */
    private void findCombines(int n, int k, int start, Stack<Integer> pre) {
        // 递归跳出条件，拿满k个
        if (pre.size() == k) {
            result.add(new ArrayList<>(pre));
            return;
        }
        //起点数字push，用完pop
        for (int i = start; i <= n; i++) {
            pre.push(i);
            findCombines(n, k, i + 1, pre);
            pre.pop();
        }
    }
}

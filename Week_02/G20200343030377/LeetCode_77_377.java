class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        combineRecur(n, k, 1, new Stack<Integer>());
        return res;
    }

    private void combineRecur(int n, int k, int begin, Stack<Integer> tmp) {
        if (tmp.size() == k) {
            res.add(new ArrayList(tmp));
            return;
        }
        for (int i = begin; i <= n; i++) {
            tmp.push(i);
            combineRecur(n, k, i + 1, tmp);
            tmp.pop();
        }
    }
}

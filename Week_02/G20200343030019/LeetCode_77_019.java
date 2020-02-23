class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n < k || k <= 0) return new ArrayList();
        ArrayList<List<Integer>> result = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        build(1, n, k, list, result);
        return result;
    }

    private void build(int layer, int n, int k, ArrayList<Integer> curList, ArrayList<List<Integer>> result) {
        if (layer > k) {
            result.add((List) curList.clone());
            return;
        }
        int begin = layer > 1?curList.get(layer - 2) + 1: 1;
        ArrayList<Integer> arr = null;
        for (; begin <= n - k + layer; begin ++) {
            curList.add(begin);
            build(layer + 1, n, k, curList, result);
            curList.remove(layer - 1);
        }
    }
}
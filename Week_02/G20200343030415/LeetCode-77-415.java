import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        recur(1,new LinkedList<>());
        return output;
    }
    List<List<Integer>> output = new LinkedList<>();
    int n;
    int k;
    public void recur(int first,LinkedList<Integer> curr){
        if(curr.size() == k){
            output.add(new LinkedList<Integer>(curr));
        }
        for (int i = first; i < n + 1; i++) {
            curr.add(i);
            recur(i + 1,curr);
            curr.removeLast();
        }

    }
}
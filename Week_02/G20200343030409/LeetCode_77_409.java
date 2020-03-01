/*
    time complexity: O(C(n, k)), space complexity: O(k)
*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k); //start from 1
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        if (k == 0) { // terminal condition: when k == 0
            result.add(new ArrayList<>(tempList));
            return;
        } else {
            for (int i = start; i <= n - k + 1; i++) { // why n - k +1, it's a precise way to indicate the range, because when jump to next recursion level, k is changed, we should recaculate to "n - k + 1", not always to use n
                tempList.add(i);
                backtrack(result, tempList, i + 1, n, k - 1);
                tempList.remove(tempList.size() - 1); // backtrack
            }
        }
    }
}
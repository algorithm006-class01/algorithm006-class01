class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        ArrayList<Integer> numsList = new ArrayList();
        for (int i: nums) {
            numsList.add(i);
        }
        generate(numsList.size(), numsList, 0, result);
        return result;
    }

    private void generate(int n, ArrayList<Integer> nums, int first, List<List<Integer>> result) {
        if (first == n) {
            result.add((List) nums.clone());
            return ;
        }
        for (int index = first; index < n; index ++) {
            Collections.swap(nums, first, index);
            generate(n, nums, first + 1, result);
            Collections.swap(nums, index, first);
        }
    }
}
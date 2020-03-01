class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        LinkedList<Integer> stack = new LinkedList();
        boolean[] used = new boolean[nums.length];
        generate(nums.length, nums, used, stack, result);
        return result;
    }

    private void generate(int n, int[] nums, boolean[] used, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (n == stack.size()) {
            result.add((List) stack.clone());
            return;
        }
        int upValue = -11111;
        for (int index = 0; index < n; index ++) {
            if (used[index] || nums[index] == upValue) {
                continue;
            }
            used[index] = true;
            stack.addLast(nums[index]);
            generate(n, nums, used, stack, result);
            upValue = nums[index];
            stack.pollLast();
            used[index] = false;
        }
    }
}
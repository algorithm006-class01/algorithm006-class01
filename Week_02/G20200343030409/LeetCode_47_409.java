/*
  use backtrack again

  time complexity: O(n*n!), space complexity: O(n*n!), n is input array length

*/

// use arraylist contains to judge it should pass or not, slower, 2ms
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean used[] = new boolean[nums.length];

        Arrays.sort(nums); // need sort
        backtrack(result, new ArrayList<>(), used, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, boolean[] used, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue; // excluding used, and duplicate permutaion

                used[i] = true;
                tempList.add(nums[i]);

                backtrack(result, tempList, used, nums);

                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }
}
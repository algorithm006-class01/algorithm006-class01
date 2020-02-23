/*
  use backtrack again

  time complexity: O(n*n!), space complexity: O(n*n!), n is input array length

*/

// use arraylist contains to judge it should pass or not, slower, 2ms
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;   // skip duplicate result

                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

// use boolean[] used to judge it should pass or not, faster, 1ms
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);

        backtrack(result, new ArrayList<>(), used, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, boolean[] used, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;

                tempList.add(nums[i]);
                used[i] = true;

                backtrack(result, tempList, used, nums);

                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }
}
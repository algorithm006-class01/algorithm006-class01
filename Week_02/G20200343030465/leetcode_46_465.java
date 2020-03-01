public class Solution {
   public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		if (nums.length == 0) {
			return permutations;
		}

		collectPermutations(nums, 0, new ArrayList<>(), permutations);
		return permutations;
    }

	private void collectPermutations(int[] nums, int start, List<Integer> permutation,
 			List<List<Integer>>  permutations) {
		
		if (permutation.size() == nums.length) {
			permutations.add(permutation);
			return;
		}

		for (int i = 0; i <= permutation.size(); i++) {
			List<Integer> newPermutation = new ArrayList<>(permutation);
			newPermutation.add(i, nums[start]);
			collectPermutations(nums, start + 1, newPermutation, permutations);
		}
	}
}
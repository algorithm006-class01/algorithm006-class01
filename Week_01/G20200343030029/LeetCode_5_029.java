import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
class LeetCode_5_029 {
	// 解题：
	// <br/>给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，
	//<br/>并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

	public static void main(String[] args) {
		// test
		solutionTest();
	}

	public static void solutionTest(){
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(hashSolution(nums, target)));
		System.out.println(Arrays.toString(violenceSolution(nums, target)));
	}

	// 1.暴力解法 时间复杂度为n^2
	public static int[] violenceSolution(int[] nums, int target) {
		int[] indexArray = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					indexArray[0] = i;
					indexArray[1] = j;
					return indexArray;
				}
			}
		}
		return indexArray;
	}

	//2. hash 解法 时间复杂度为n
	// map<value. index>
	public static int[] hashSolution(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int indexValue = target - nums[i];
			if (map.containsKey(indexValue)) {
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum value");
	}
}
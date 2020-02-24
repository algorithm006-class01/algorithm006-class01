import java.util.Arrays;

class LeetCode_6_029 {
	//题解：
	// <br/>给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
	//输入: [0,1,0,3,12]
	//输出: [1,3,12,0,0]

	public static void main(String[] args) {
		solutionTest();
	}

	public static void solutionTest() {
		int[] nums = {0, 1, 0, 3, 12};
		System.out.println(Arrays.toString(violenceSolution(nums)));
		System.out.println(Arrays.toString(speedPointerSolution(nums)));
	}

	/**
	 * 暴力求解  时间复杂度 n^2
	 */
	public static int[] violenceSolution(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (0 == nums[i] && 0 != nums[j]) {
					swap(i, j, nums);
				}
			}
		}
		return nums;
	}

	/**
	 * 快慢指针，快指针指向非零指针，慢指针指向零元素，交换, 时间复杂度为n
	 */
	public static int[] speedPointerSolution(int nums[]) {
		for(int fast = 0, slow = 0; fast < nums.length; fast++){
			if(0 != nums[fast]){
				swap(fast, slow, nums);
				slow++;
			}
		}
		return nums;
	}

	public static void swap(int index1, int index2, int[] nums) {
		int tempvalue = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = tempvalue;
	}
}
class LeetCode_12_029{
	// 题目描述：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
	//
	//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
	//
	//请找出其中最小的元素。
	//
	//你可以假设数组中不存在重复元素。
	//
	//来源：力扣（LeetCode）
	//链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
	//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	public static void main(String[] args) {
		int[] array1 = {3,1,2};
		int[] array2 = {3,4,5,1,2};
		System.out.println("violent solution result of array1: " + violentSolutionOfFindMin(array1) );
		System.out.println("violent solution result of array2: " + violentSolutionOfFindMin(array2));
		System.out.println("binary serach result of array2: " + binarySearchOfFindMin(array1));
		System.out.println("binary serach result of array2: " + binarySearchOfFindMin(array2));
	}

	/**
	 * 暴力解法
	 */
	public static int violentSolutionOfFindMin(int[] nums) {
		if(null == nums){
			throw new IllegalArgumentException("method param is null.");
		}
		int num = nums[0];
		for(int i = 0; i < nums.length; i++) {
			num = num < nums[i] ? num : nums[i];
		}
		return num;
	}

	/**
	 * 1.存在上下边界
	 * 2.单调性（有序）
	 * 3.能够通过索引访问
	 */
	public static int binarySearchOfFindMin(int[] nums){
		if(null == nums) {
			throw new IllegalArgumentException("method param exception");
		}

		if((nums.length == 1) || (nums[0] < nums[nums.length - 1]) ){
			return nums[0];
		}

		int left = 0;
		int right = nums.length - 1;

		while(left < right) {
			int mid = left + (right - left) / 2;

			if(nums[mid] > nums[mid + 1]){
				return nums[mid + 1];
			}

			if(nums[mid - 1] > nums[mid]) {
				return nums[mid];
			}
			if(nums[mid] > nums[0]){
				left++;
			}else{
				right--;
			}
		}
		return -1;
	}
}
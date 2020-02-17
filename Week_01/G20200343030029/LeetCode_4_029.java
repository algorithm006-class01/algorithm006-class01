import java.util.Arrays;
class LeetCode_4_029 {
	//题解：给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
	//初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
	//你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

	public static void main(String[] args) {
		solutionTest();
	}

	public static void solutionTest() {
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		int m = 3;
		int[] nums2 = {2, 5, 6};
		int n = 3;
		//System.out.println(Arrays.toString(violenceSolution(nums1, m, nums2, n)));
		System.out.println(Arrays.toString(bigNumLastSolution(nums1, m, nums2, n)));
	}

	/**
	 * 暴力求解，先拷贝数组，然后排序，，时间复杂度 O((n+m)log(n+m))
	 */
	public static int[] violenceSolution(int[] nums1, int m, int[] nums2, int n) {
		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
		return nums1;
	}

	/**
	 *两个数组，从后往前遍历，最大的数相互比较，最大的数在nums1[]末尾 时间复杂度为O(n+m)
	 */
	public static int[] bigNumLastSolution(int[] nums1, int m, int[] nums2, int n) {
		int endIndex = nums1.length - 1;
		int endNums1Index = m - 1;
		int endNums2Index = n - 1;
		while (endNums2Index >= 0){
			if(endNums1Index < 0){
				nums1[endIndex--] = nums2[endNums2Index--];
			}else if(nums1[endNums1Index] > nums2[endNums2Index]){
				nums1[endIndex--] = nums1[endNums1Index--];
			}else{
				nums1[endIndex--] = nums2[endNums2Index--];
			}
		}
		return nums1;
	}

}
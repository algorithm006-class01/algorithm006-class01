import java.util.Arrays;

/*
 * 88. Merge Sorted Array
 * 合并两个有序数组
 */
public class LeetCode_88_569 {

	public static void main(String[] args) {
		int[] nums1 = { 1,2,3,0,0,0 };
		int[] nums2 = { 2,5,6 };
		(new LeetCode_88_569()).new Solution().merge(nums1, 3, nums2, 3);
		for( int i = 0; i < nums1.length; i++ ){
			System.out.println(nums1[i]);
		}
	}

	class Solution {
	    public void merge(int[] nums1, int m, int[] nums2, int n) {
	        System.arraycopy(nums2, 0, nums1, m, n);
	        Arrays.sort(nums1);
	    }
	}
}

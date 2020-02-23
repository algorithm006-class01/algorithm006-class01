package FistWork;
// 自己思路： 分别遍历数组1 ，数组2 ， 合并到一起组成数组3， 在遍历一次，排序，成数组4
//  最终还是使用(copy代码)leetCode的代码
public class Solution02 {
	public void merge(int[] nums1,int m , int[] nums2, int n){
		int len1 = m - 1;
		int len2 = n - 1;
		int len = m + n - 1;
		while(len1 >= 0 && len2 >= 0){
			nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
			System.arraycopy(nums2,0,nums1,0,len2+1);
		}
	}

}

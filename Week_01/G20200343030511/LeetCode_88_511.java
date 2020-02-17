class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      if (nums1.length < nums2.length)
			return ;
		
		int l =m-1;
		int k= n-1;
		int p =m+n-1;
		
		while(l>=0&&k>=0){
			if(nums1[l]<nums2[k]){
				nums1[p]=nums2[k];
				k--;
				p--;
			}else{
				nums1[p]=nums1[l];
				l--;
				p--;
			}

    }
    System.arraycopy(nums2, 0, nums1, 0, k + 1);
    }
}
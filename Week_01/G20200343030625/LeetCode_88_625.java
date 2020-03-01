class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        System.arraycopy(nums1, 0, tmp, 0, m);

        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n)) {
            if(tmp[p1] < nums2[p2]){
                nums1[p++] = tmp[p1++];
            }else{
                nums1[p++] = nums2[p2++];
            }
        }
        if(p1 < m){
            System.arraycopy(tmp, p1, nums1, p, m - p1);
        }
        if(p2 < n){
            System.arraycopy(nums2,p2,nums1,p,n - p2);
        }
    }
}

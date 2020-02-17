package merge_sorted_array;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int a = 0;
        int b = 0;
        int c = 0;
        while(a<m && b<n){
            temp[c] = nums1[a] > nums2[b]? nums2[b++]:nums1[a++];
            c++;
        }
        if (a<m){
            System.arraycopy(nums1,a,temp,n+a,m-a);
        }
        if (b<n){
            System.arraycopy(nums2,b,temp,m+b,n-b);
        }
        System.arraycopy(temp,0,nums1,0,m+n);
    }

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int m = 3;
        int[] nums2 = {1,2,3};
        int n = 3;
        Solution s = new Solution();
        s.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}

/*
1. use two pointer
2. there is a enough space of nums1 to put nums1's data and nums2's data,
    so create a m+n index to store the result
3. compare element from array's last, and then put them to m+n nums1's from last index
4. at last, if nums2 still has element, put them all into nums1

    time complexity: O(n), space complexity: O(1)

*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }
}
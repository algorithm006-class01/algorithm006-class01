class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        auto i = m-1;
        auto j = n-1;
        auto k = m+n-1;
        while (i>=0&&j>=0) nums1[k--]=nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
        while (i>=0) nums1[k--]=nums1[i--];
        while (j>=0) nums1[k--]=nums2[j--];

        return;
        
    }
};

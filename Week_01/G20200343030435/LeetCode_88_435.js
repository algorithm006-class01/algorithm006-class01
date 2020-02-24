let count = m + n;
while (m > 0 && n > 0) {
  nums1[--count] = nums1[m - 1] < nums2[n - 1] ? nums2[--n] : nums1[--m];
}
if (n > 0) {
  nums1.splice(0, n, ...nums2.splice(0, n));
}

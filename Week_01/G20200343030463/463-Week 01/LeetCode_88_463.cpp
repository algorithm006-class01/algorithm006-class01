课后作业
004 https://leetcode-cn.com/problems/merge-sorted-array/
解题思路:
逆向考虑:题目中看到num1是给足空间的,可以从num1 num2尾部着手 将
num1 num2尾部较大的元素放置在num中m + n - 1的位置上

class Solution {
public:
void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {

int i = m - 1, j = n - 1, newvector = m + n - 1;
while (j >= 0) {
nums1[newvector--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
}
}
};

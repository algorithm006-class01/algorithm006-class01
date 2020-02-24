/*
    it's really magic...
    1. reverse entire array
    2. reverse the partial array of 0 ~ k-1
    3. reverse the partial array of k ~ end
    4. it's the answer

    time complexity: O(n), space complexity: O(1)

*/
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k -1);
        reverse(nums, k, len - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
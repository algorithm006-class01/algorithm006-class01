// time complexity: O(n), space complexity: O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        int size = 0;
        if (nums == null) return size;

        for (int num : nums) {
            if(nums[size] != num) {
                nums[++size] = num; // only need to know the size at last
            }
        }

        return size+1;
    }
}
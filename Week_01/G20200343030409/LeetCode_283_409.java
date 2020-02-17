/*
   time complexity: O(n), space complexity: O(1)
 */
class Solution {
    public static void moveZeroes(int[] nums) {
        int leftMostZeroIndex = 0; // The index of the leftmost zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > leftMostZeroIndex) { // There are zero(s) on the left side of the current non-zero number, swap!
                    nums[leftMostZeroIndex] = nums[i]; //do swap!! so smart
                    nums[i] = 0;
                }

                leftMostZeroIndex++; // notice this poistion here
            }
        }
    }
}
/*
    there is two part are ordered.

    use nested binary search to find

    if (nums[mid] == target) {
        return mid;
    } else if (nums[mid] >= nums[left]) {

        //check target in which part, then to adjust right or left index
    } else {

        //check target in which part, then to adjust right or left index
    }

    time complexity: O(logn), space complexity: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;

            } else if (nums[mid] >= nums[left]) { //first, try to assure which part is we want (left part)

                if (nums[mid] >= target && target >= nums[left]) { // then try to find target in this part
                    right = mid - 1; // this means target is really in left part
                } else {
                    left = mid + 1; // means not in left part, it should be in right part
                }

            } else { // assure which part is we want (right part)

                if (nums[right] >= target && target >= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
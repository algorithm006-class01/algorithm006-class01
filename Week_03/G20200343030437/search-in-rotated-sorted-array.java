public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length-1;
//第一次靠自己写的击败100%的题目
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            else if((nums[mid] < nums[right] && !(target > nums[mid]
                    && target <= nums[right])) || (target >= nums[left] && target < nums[mid])) {
                // 往左走
                right = mid - 1;
            }
            else {
                // 往右走
                left = mid + 1;
            }
        }
        return -1;
    }

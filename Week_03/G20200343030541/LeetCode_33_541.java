public class LeetCode_33_541 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while ( start <= end ) {
            mid = start + ( end - start) / 2;
            if ( nums[mid] == target ) {
                return mid;
            }

            // 前半部分升序，注意此处用小于等于
            if ( nums[start] <= nums[mid] ) {
                // target 在前半部分
                if( target >= nums[start] && target < nums[mid] ){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            // 后半部分升序
            } else {
                if( target >= nums[start] && target < nums[mid] ){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }
}

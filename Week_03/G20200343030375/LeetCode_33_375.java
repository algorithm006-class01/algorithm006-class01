package G20200343030375;

public class LeetCode_33_375 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left < right ){
            int mid = (left + right)/2;
            //左侧有序  && 目标大于mid，或目标小于开始0，说明目标不在左边
            if(nums[0] <= nums[mid]  &&(target > nums[mid] || target <nums[0] )){
                left = mid +1;
            }else if (target > nums[mid] && target < nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == right && nums[left] == target ? left : -1;

    }
}

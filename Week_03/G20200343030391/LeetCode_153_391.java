package G20200343030391;

public class LeetCode_153_391 {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int min = new LeetCode_153_391().findMin(nums);
        System.out.println(min);
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }

}

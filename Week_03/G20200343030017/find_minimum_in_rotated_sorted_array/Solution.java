package week3.find_minimum_in_rotated_sorted_array;

public class Solution {
    public int findMin(int[] nums) {
        if (nums.length<=1) return nums[0];
        int begin =0;
        int end = nums.length-1;
        int mid;
        while(begin<end){
            mid = (begin+end)/2;
            if (nums[end]<nums[begin] && nums[begin]<=nums[mid]){
                begin=mid+1;
            }
            if (nums[begin]<=nums[mid] && nums[mid]<nums[end]){
                return nums[begin];
            }
            if (nums[mid]<nums[end] && nums[end]<nums[begin]){
                begin=begin+1;
                end=end-1;
            }
        }
        return nums[begin];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2};
        //int[] nums = {4,5,6,7,0,1,2};
        Solution s = new Solution();
        System.out.println(s.findMin(nums));
    }
}

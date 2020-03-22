package week3.search_in_rotated_sorted_array;

public class Solution {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        int mid = 0;
        while(begin<=end){
            mid = (begin+end)/2;
            if (nums[mid]==target){
                return mid;
            }else{
                if (nums[begin]<=nums[mid]){
                    if (target<nums[mid]&&target>=nums[begin]){
                        end=mid;
                        --end;
                    }else{
                        begin=mid;
                        ++begin;
                    }
                }else{
                    if (target>nums[mid]&&target<=nums[end]){
                        begin=mid;
                        ++begin;
                    }else{
                        end=mid;
                        --end;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        Solution s = new Solution();
        System.out.println(s.search(nums,0));
    }
}

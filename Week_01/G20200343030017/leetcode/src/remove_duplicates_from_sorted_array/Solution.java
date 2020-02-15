package remove_duplicates_from_sorted_array;
import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int a = 0;
        for (int n=0;n<nums.length-1;n++){
            for(int j = n+1;j<nums.length;j++){
                if (nums[j] > nums[n]){
                    nums[n+1] = nums[j];
                    a = a + 1;
                    break;
                }
                if (nums[j] == nums[nums.length-1]){
                    return a+1;
                }
            }
        }
        return a+1;
    }

    public static void main(String[] args) {
        int[] a ={0,0,0};
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(a));
        System.out.println(Arrays.toString(a));
    }
}

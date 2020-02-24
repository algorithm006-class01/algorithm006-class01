package Week_01.G20200343030395;

public class LeetCode_6_395 {

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for(int i=0; i<nums.length; ++i){
            if(nums[i] != 0) {
                nums[j] = nums[i];
                if(i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}

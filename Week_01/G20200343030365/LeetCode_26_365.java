package homework.week_01;

/**
 * 删除排序数组中的重复项
 */
public class LeetCode_26_365 {

    public int removeDuplicates(int[] nums) {

        if(nums.length == 0) return 0;
        int i = 0;

        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}

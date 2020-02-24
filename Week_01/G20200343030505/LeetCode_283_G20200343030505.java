/**
 * 
 */

/**
 * @author huangwen05
 *
 * @date:   2020年2月16日 下午8:49:22 
 */
public class LeetCode_283_G20200343030505 {

    public void moveZeroes(int[] nums) {
       if(nums == null) {
           return;
       } 

        int index = -1;
        for(int i=0;i<nums.length;++i) {
            if(nums[i] != 0) {
                ++index;
                if(index != i) {
                    nums[index] = nums[i];
                }
            }
        }

        for(int i=index + 1;i<nums.length;++i) {
            nums[i] = 0;
        }
    }
}
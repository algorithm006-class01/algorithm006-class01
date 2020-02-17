/**
 * 
 */

class LeetCode_26_G20200343030505 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int index = -1;
        for(int i=0;i<nums.length;++i) {
            if(i == 0) {
                index = 0;
            } else {
                if(nums[i] != nums[index]) {
                    ++index;
                    nums[index] = nums[i];
                }
            }
        }

        for(int i=index + 1;i<nums.length;++i) {
            nums[i] = 0;
        }

        return index + 1;

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }    
}


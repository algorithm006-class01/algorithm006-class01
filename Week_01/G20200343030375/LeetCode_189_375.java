package G20200343030375;

/**
 * 第一种实现方式
 * 暴力实现
 */
class LeetCode_189_375 {
    public void rotate(int[] nums, int k) {
        for(int i=1;i<=k;++i){
            int temp = nums[nums.length-1];
            for(int j = nums.length-1;j>0;j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }
}

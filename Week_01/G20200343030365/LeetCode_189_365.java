package homework.week_01;

/**
 * 旋转数组
 */
public class LeetCode_189_365 {

    //暴力方法，
    //时间复杂度O(n*k)
    public void rotate1(int[] nums, int k) {

        for( int i = 0; i < k; i++){
            //记录最后一个数
            int last = nums[nums.length - 1];
            //全部后移
            for(int j = nums.length -1; j > 0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = last;
        }
    }

    // 反转
    public void rotate2(int[] nums, int k) {

        int length = nums.length;
        k %= length;
        reverse(nums,0,length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,length-1);

    }


    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}

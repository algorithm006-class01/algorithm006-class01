package Week_01.G20200343030395;

import java.util.Arrays;

public class LeetCode_2_395 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        rotate(nums, 4);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        k = k%nums.length;//取余，因为长7，移动7次，等于没动，取剩下的就行了

        reverse(nums, 0, nums.length - 1);//全部翻转
        reverse(nums, 0, k - 1);//把前k个再翻转过来
        reverse(nums, k, nums.length - 1);//把后n-k个翻转过来
    }

    //翻转start到end的数组
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            //头尾互换
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            //往中间缩
            start++;
            end--;
        }
    }

    public static void rotateFor(int[] nums, int k) {

        k = k%nums.length;//取余，因为长7，移动7次，等于没动，取剩下的就行了

        //移动k次
        for (int i=0; i<k;i++) {
            int temp = nums[nums.length -1]; //保存最后一个

            //因为要往后挪动，所以要从后面往前遍历，防止覆盖
            //把后面的赋值为前一位
            for (int j=nums.length-1; j > 0; j--) {
                nums[j] = nums[j-1];
            }

            //脑袋赋值为最后一个
            nums[0] = temp;
        }


    }
}

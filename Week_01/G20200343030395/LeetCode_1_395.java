package Week_01.G20200343030395;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_1_395 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0,1,1,2,3};
        int num = removeDuplicates(nums);
        System.out.println(num);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }

        int i = 0;
        for(int j=1; j<nums.length;) {
            //如果num[i] == num[j],j一直往后走，直到第一个和num[i]不相等的地方为止
            if (nums[i] == nums[j]) {
                j++;
            } else {
                //把num[i+1]赋值为num[j]
                //所以只是前半段处理过，后面的还是重复的，但是不重要
                nums[++i] = nums[j];
                j++;
            }
        }

        return i+1;
    }
}
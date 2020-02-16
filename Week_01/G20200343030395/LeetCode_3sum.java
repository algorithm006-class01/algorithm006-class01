package Week_01.G20200343030395;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_3sum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //List<List<Integer>> x = s.threeSum(nums);
        List<List<Integer>> x = threeSum(nums);
        System.out.print(x);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> x = new ArrayList();
        for(int i=0;i<nums.length-2; ++i) {
            for(int j=i+1;j<nums.length-1;++j){
                for(int z=j+1;z<nums.length;++z) {
                    if(nums[i] + nums[j] + nums[z] == 0) {
                        x.add(Arrays.asList(nums[i], nums[j], nums[z]));
                    }
                }
            }
        }

        return x;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return ls;
    }


}

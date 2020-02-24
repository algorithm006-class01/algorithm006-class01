package G20200343030423;

import java.util.Arrays;

public class LeetCode_26_423 {

    public static void main(String[] args) {

        int[] a = {1, 1, 2};
        printResult(a);

        int[] b = {0,0,1,1,1,2,2,3,3,4};
        printResult(b);
    }

    private static void printResult(int[] a) {
        int size = removeDuplicates(a);
        System.out.println("left size: " + size);
        System.out.println(Arrays.toString(a));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}

package Week_01;

import java.util.Arrays;

public class Leetcode_026_001 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0, j = 1;

        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }

            j++;
        }

        return i + 1;
    }

    public static void main(String[] args) {
        RamdomArray ramdomArray = new RamdomArray();
        Leetcode_026_001 solution = new Leetcode_026_001();

        for (int i = 0 ; i < 15; i++) {
            int[] array = ramdomArray.generate(i, 10);
            Arrays.sort(array);

            System.out.println(Arrays.toString(array) + "\t" +solution.removeDuplicates(array));
        }
    }
}

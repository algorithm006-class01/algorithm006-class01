package Week_01;

import java.util.Arrays;

public class Leetcode_189_001 {
    public static void main(String[] args) {
        RamdomArray ramdomArray = new RamdomArray();
        Leetcode_189_001 solution = new Leetcode_189_001();

        for (int i = 0; i < 10; i++) {
            int[] arr = ramdomArray.generate(i, 100);
            int k = (int)(Math.random() * 10);

            System.out.print(Arrays.toString(arr) + "\t" + k + "\t");

            solution.rotate(arr, k);

            System.out.println(Arrays.toString(arr));
        }
    }

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }

        int len = nums.length;
        k = k % len;

        reverse(nums, 0, len-1);
        reverse(nums, k, len-1);
        reverse(nums, 0, k-1);
    }

    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}

package G20200343030423;
import java.util.Arrays;

public class LeetCode_189_423 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        rotate(a, 3);
        System.out.println(Arrays.toString(a));
        int[] b = {-1,-100,3,99};
        rotate(b, 2);
        System.out.println(Arrays.toString(b));

    }

    public static  void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] b = new int[nums.length];
        for (int i = nums.length - k, j = 0; j < nums.length; j++, i++ ) {
            b[j] = nums[i % nums.length];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = b[i];
        }
    }


}

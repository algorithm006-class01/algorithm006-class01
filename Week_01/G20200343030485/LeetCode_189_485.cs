public class Solution {
    public void Rotate(int[] nums, int k) {
        int count = 0;
        for (int i = 0; count < nums.Length; i++) {
            int targetIndex = i;
            int numLast = nums[i];
            do {
                targetIndex = (targetIndex + k) % nums.Length;
                int numTmp = nums[targetIndex];
                nums[targetIndex] = numLast;

                numLast = numTmp;

                count++;
            } while (targetIndex != i);
        }
    }
}
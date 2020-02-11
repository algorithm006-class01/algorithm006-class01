public class LeetCode_25_377 {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                if (j - i > 1) {
                    nums[i + 1] = nums[j];
                }
                i++;
            }
        }
        return i + 1;
    }

}

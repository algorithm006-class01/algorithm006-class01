package follow.phenix.ice.algorithm.weekone;

/**
 * @author iceiceice
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("methodOne result: " + methodOne(nums));
    }

    private static int methodOne(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[index + 1] = nums[i];
                index = index + 1;
            }
        }
        return index + 1;
    }
}

// Version1
public static int removeDuplicates(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
        int tmp = nums[i];
        for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == tmp) {
        result = result - 1;
        break;
        }
        }
        }
        return result;
        }
// Version2
public static int removeDuplicates(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
        if (nums[i] != nums[result]) {
        result++;
        nums[result] = nums[i];
        }
        }
        return result + 1;
        }
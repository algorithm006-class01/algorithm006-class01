package Week_07;

public class Leetcode_1122_001 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] nums = new int[1001];
        int[] res = new int[arr1.length];

        for (int i : arr1) {
            nums[i]++;
        }

        int index = 0;
        for (int i : arr2) {
            while (nums[i]>0){
                res[index++] = i;
                nums[i]--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i]>0){
                res[index++] = i;
                nums[i]--;
            }
        }

        return res;
    }
}

package datast.sort;

public class LeetCode_1122_611 {
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] countingArray = new int[1001];
            for (int num : arr1) {
                countingArray[num]++;
            }
            int[] res = new int[arr1.length];
            int index = 0;
            for (int num : arr2) {
                while (countingArray[num]-- > 0) {
                    res[index++] = num;
                }
            }
            for (int i = 0; i < 1001; i++) {
                while (countingArray[i]-- > 0) {
                    res[index++] = i;
                }
            }
            return res;
        }
    }
}

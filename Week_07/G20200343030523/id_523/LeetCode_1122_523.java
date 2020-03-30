package sort;

/**
 * https://leetcode-cn.com/problems/relative-sort-array
 * Created by bluzelee on 2020/3/29.
 */
public class RelativeSortArray01 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] bucket = new int[1001];
        for (int value : arr1) {
            bucket[value]++;
        }

        int index = 0;
        for (int i : arr2) {
            while (bucket[i] > 0) {
                arr1[index++] = i;
                bucket[i]--;
            }
        }

        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr1[index++] = i;
                bucket[i]--;
            }
        }

        return arr1;
    }

    public static void main(String[] args) {
        RelativeSortArray01 array = new RelativeSortArray01();
        int[] arr1 = new int[]{2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31};
        int[] arr2 = new int[]{2, 42, 38, 0, 43, 21};
        int[] result = array.relativeSortArray(arr1, arr2);
        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}

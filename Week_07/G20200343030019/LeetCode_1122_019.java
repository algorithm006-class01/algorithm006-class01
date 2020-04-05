class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1001];
        for (int i: arr1) {
            arr[i] ++;
        }
        int index = 0;
        for (int i: arr2) {
            for (; arr[i] > 0; arr[i] --){
                arr1[index ++] = i;
            }
        }
        for(int i = 0; i < 1001; i ++) {
            if (arr[i] > 0)
                for (; arr[i] > 0; arr[i] --) {
                    arr1[index ++] = i;
                }
        }
        return arr1;
    }
}
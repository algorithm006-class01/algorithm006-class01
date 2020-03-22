class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length <= 0) return 0;
        int[] arr = new int[matrix[0].length + 1];
        int max = 0;
        int pre = 0;
        for (int i = 1; i <= matrix.length; i ++) {
            for (int j = 1; j <= matrix[0].length; j ++) {
                int temp = arr[j];
                if (matrix[i - 1][j - 1] != '1') {
                    arr[j] = 0;
                    continue;
                }
                arr[j] = 1 + Math.min(Math.min(arr[j - 1], pre), arr[j]);
                if (arr[j] > max) max = Math.max(arr[j], max);
                pre = temp;
            }
        }
        return max * max;
    }
}
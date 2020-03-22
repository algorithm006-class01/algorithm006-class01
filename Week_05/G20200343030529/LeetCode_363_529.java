class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int result = Integer.MIN_VALUE;
        for (int left = 0; left < col; left++) {
            int[] rowSum = new int[row];
            for (int right = left; right < col; right++) {
                for (int i = 0; i < row; i++) {
                    rowSum[i] += matrix[i][right];
                }
                result = Math.max(result, findBestSum(rowSum, k));
            }
        }
        return result;
    }
    
    private int findBestSum(int[] rowSum, int k ) {
        int result = Integer.MIN_VALUE;
        int cum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int sum : rowSum) {
            cum += sum;
            Integer num = set.ceiling(cum - k);
            if (num != null) result = Math.max(result, cum - num);
            set.add(cum);
        }
        return result;
    }
}
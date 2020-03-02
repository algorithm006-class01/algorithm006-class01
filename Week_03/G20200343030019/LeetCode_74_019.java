class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int lo = 0;
        int hi = matrix.length - 1;
        int mi = 0;
        while (lo < hi) {
            mi = lo + (hi - lo) / 2;
            if (target < matrix[mi][0]) {
                hi = mi - 1;
            } else if (target > matrix[mi][0]) {
                lo = mi + 1;
            } else {
                lo = mi;
                break;
            }
        }
        int i = matrix[lo][0] > target && lo > 0? lo - 1: lo;
        lo = 0;
        hi = matrix[i].length - 1;
        while (lo < hi) {
            mi = lo + (hi - lo) / 2;
            if (target < matrix[i][mi]) {
                hi = mi - 1;
            } else if (target > matrix[i][mi]){
                lo = mi + 1;
            } else {
                lo = mi;
                break;
            }
        }

        return matrix[i][lo] == target;
    }
}
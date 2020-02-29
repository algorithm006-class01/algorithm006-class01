/*
    use binary search

    time complexity: O(log(m*n)) space complexity: O(1)
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int m = matrix.length; // 2d -> look as a 1-d array, matrix[m][n] looks like a[m*n]
        int n = matrix[0].length;

        int left = 0;
        int right = m*n - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            int matrixVal = matrix[mid/n][mid%n]; // 1d index

            if (matrixVal == target) {
                return true;
            }

            if (matrixVal > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
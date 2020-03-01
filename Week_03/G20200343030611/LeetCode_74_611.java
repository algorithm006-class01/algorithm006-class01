package datast.binary_search;

public class LeetCode_74_611 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int valueIndex = matrix[mid / n][mid % n];
            if (valueIndex == target) {
                return true;
            } else if (valueIndex < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

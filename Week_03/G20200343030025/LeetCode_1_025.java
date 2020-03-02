public class LeetCode_1_025 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int mid, midVal;
        while (left <= right) {
            mid = (left + right) / 2;
            midVal = matrix[mid / n][mid % n];
            if (target == midVal) {
                return true;
            } else if (target < midVal) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
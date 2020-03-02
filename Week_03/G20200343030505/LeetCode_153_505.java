class LeetCode_74_505 {
   public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int dx = mid/n, dy = mid%n;
            if (matrix[dx][dy] == target) {
                return true;
            } else if (matrix[dx][dy] > target) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
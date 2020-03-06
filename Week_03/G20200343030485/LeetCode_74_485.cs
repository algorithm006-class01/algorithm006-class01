public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        int row = matrix.Length;
        if (row == 0) {
            return false;
        }

        int col = matrix[0].Length;
        if (col == 0) {
            return false;
        }

        int left = 0;
        int right = row - 1;
        int targetRow = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            }
            else if (matrix[mid][col-1] < target) {
                left = mid + 1;
            }
            else {
                targetRow = mid;
                break;
            }
        }

        if (targetRow == -1) {
            return false;
        }

        left = 0;
        right = col - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            }
            else if (matrix[targetRow][mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return false;
    }
}

//官方解，更简洁，一次二分查找搞定
public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        int row = matrix.Length;
        if (row == 0) {
            return false;
        }

        int col = matrix[0].Length;
        if (col == 0) {
            return false;
        }

        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = matrix[mid/col][mid%col];
            if (value == target) {
                return true;
            }
            else if (value < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return false;
    }
}
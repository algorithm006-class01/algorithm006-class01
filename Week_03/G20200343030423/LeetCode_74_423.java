public class LeetCode_74_423 {

}

class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix != null && matrix.length > 0) {
            int left = 0;
            int row = matrix.length;
            int clo = matrix[0].length;
            int right = row * clo - 1;
            int mid ;
            while (left <= right) {
                mid = left + (right-left)/2;
                if (matrix[(mid)/clo][(mid%clo)] == target) {
                    return true;
                }
                if (matrix[(mid)/clo][(mid%clo)] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
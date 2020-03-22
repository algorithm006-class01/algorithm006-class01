package G20200343030391;

public class LeetCode_74_391 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1}
        };
        int target = 3;
        boolean b = new LeetCode_74_391().searchMatrix(matrix, target);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / col][mid % col] == target) {
                return true;
            } else if (matrix[mid / col][mid % col] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 边界条件
        if (null == matrix || matrix.length == 0 ) {
            return false;
        }
        // 获取多维数组维数及每一维元素个数
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        int searchRowAt = rowCount - 1;
        // 特殊边界，如果最后一个元素还小于target或者第一个元素大于target，直接返回false
        if (columnCount == 0 || matrix[0][0] > target || matrix[searchRowAt][columnCount - 1] < target) {
            return false;
        }
        // 找到target在哪一行内
        while (searchRowAt > 0) {
            if (matrix[searchRowAt][0] > target) {
                searchRowAt--;
            }else if (matrix[searchRowAt][columnCount - 1] >= target && matrix[searchRowAt][0] <= target){
                break;
            }else {
                searchRowAt--;
            }
        }
        // 在行内进行二分查找
        int low = 0;
        int high = columnCount - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[searchRowAt][mid] == target || matrix[searchRowAt][low] == target
                    || matrix[searchRowAt][high] == target) {
                return true;
            } else if (matrix[searchRowAt][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
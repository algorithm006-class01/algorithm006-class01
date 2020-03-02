/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
      if (matrix.length == 0 || matrix[0].length == 0) return false;

      int start = 0;
      int end = (matrix.length * matrix[0].length) - 1;
      int colNum = matrix[0].length;

      while (start <= end) {
          int mid = (start + end) / 2;

          int tempRow = (mid / colNum);
          int tempCol = (mid % colNum);

          if (matrix[tempRow][tempCol] == target) return true;
          if (matrix[tempRow][tempCol] < target) {
              start = mid +1;
          }
          else {
              end = mid - 1;
          }
      }
      return false;
  }
}
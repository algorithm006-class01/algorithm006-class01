/**
 * 74. 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 
 */


class Solution {
public:
    // 二分查找
    // 时间复杂度：O(log(m*n))
    // 空间复杂度：O(1)
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.empty() || matrix[0].empty()){
            return false;
        }

        int left = 0, right = matrix.size() * matrix[0].size() -1;
        int n = matrix[0].size();
        int pivotIdx;
        while(left <= right){
            pivotIdx = (left + right) / 2;

            if(target == matrix[pivotIdx / n][pivotIdx % n]){
                return true;
            }else if(target < matrix[pivotIdx / n][pivotIdx % n]){
                right = pivotIdx - 1; 
            } else {
                left = pivotIdx + 1;
            }
        }

        return false;
    }
};
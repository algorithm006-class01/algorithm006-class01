// https://leetcode-cn.com/problems/search-a-2d-matrix/

//二维数组整体升序，因此当作一维数组
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {

        if ( matrix.size() == 0 ) return false;
        int row = matrix.size();
        int col = matrix[0].size();
        
        int left = 0, right = row * col - 1;
        
        while (left <= right){
            int mid = left + (right-left) / 2;
            int ele = matrix[mid/col][mid%col];
            if ( target == ele) return true;
            if ( target > ele){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        return false;

    }
};
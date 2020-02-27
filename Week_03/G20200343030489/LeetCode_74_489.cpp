/*
 * @lc app=leetcode.cn id=74 lang=cpp
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.empty()||matrix[0].empty())
            return 0;
        int left=0,right=matrix.size()*matrix[0].size()-1;
        int n=matrix[0].size();
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(matrix[mid/n][mid%n]>target)
                right=mid-1;
            else if(matrix[mid/n][mid%n]<target)
                left=mid+1;
            else
                return true;
            
        }
        return false;
    }
};
// @lc code=end


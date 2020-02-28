package week3.search_a_2d_matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0||matrix[0].length==0){
            return false;
        }
        int begin = 0;
        int end = matrix.length-1;
        int mid = 0;
        int size = matrix[0].length;
        int k = -1;
        while(begin<=end){
            mid = (begin+end)/2;
            if (k==-1){
                if (matrix[mid][0]==target){
                    return true;
                }
                if (target>matrix[mid][0] && target<=matrix[mid][size-1]){
                    begin=0;
                    end=size-1;
                    k = mid;
                }
                if (target<matrix[mid][0]){
                    end--;
                }
                if (target>matrix[mid][0]){
                    begin++;
                }
            }else{
                if (matrix[k][mid]==target){
                    return true;
                }
                if (target<matrix[k][mid]){
                    end--;
                }
                if (target>matrix[k][mid]){
                    begin++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1,3,5,7},{10, 11, 16, 20},{23, 30, 34, 50}};
        //int target = 3;
        int[][] matrix ={{1,3}};
        int target = 3;
        Solution s = new Solution();
        System.out.println(s.searchMatrix(matrix,target));
    }
}

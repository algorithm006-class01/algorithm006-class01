package week5.max_sum_of_rectangle_no_larger_than_k;

public class Solution {
    //temp[y][x]=Math.min(Math.min(temp[y-1][x-1],temp[y-1][x]),temp[y][x-1])+1;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int min = 0;
        int[][] temp = new int[matrix.length+1][matrix[0].length+1];
        for (int y = 0; y < matrix.length + 1; y++){
            temp[y][0] = 0;
        }
        for (int x = 0; x < matrix[0].length + 1; x++){
            temp[0][x] = 0;
        }
        for (int y=1;y<=matrix.length;y++){
            for (int x=1;x<=matrix[0].length;x++){
                temp[y][x]=temp[y-1][x]-temp[y][x-1]-temp[y-1][x-1]+matrix[y-1][x-1];
                System.out.println(temp[y][x]);
                int pre = min;
                min = Math.min(k-temp[y][x],min);
                if (min<0){
                    min = pre;
                }
            }
        }
        return k-min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,2,-1}};
        int k = 0;
        Solution s = new Solution();
        System.out.println(s.maxSumSubmatrix(matrix,k));
    }
}

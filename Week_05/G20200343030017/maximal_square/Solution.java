package week5.maximal_square;

import java.util.Arrays;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length==0) return 0;
        int[][] temp = new int[matrix.length+1][matrix[0].length+1];
        for (int n=0;n<temp.length;n++){
            Arrays.fill(temp[n],0);
        }
        int l = 0;
        for (int y=1;y<=matrix.length;y++){
            for (int x=1;x<=matrix[0].length;x++){
                if (matrix[y-1][x-1]=='1'){
                    temp[y][x]=Math.min(Math.min(temp[y-1][x-1],temp[y-1][x]),temp[y][x-1])+1;
                    l= Math.max(temp[y][x],l);
                }
            }
        }
        return l*l;
    }

    public static void main(String[] args) {
        /*char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };*/
        char[][] matrix ={{'1'}};
        Solution s = new Solution();
        System.out.println(s.maximalSquare(matrix));
    }
}

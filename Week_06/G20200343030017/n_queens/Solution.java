package week6.n_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> last = new ArrayList<>();
        int[][] queens = new int[n][n];
        for (int j=0;j<queens.length;j++){
            Arrays.fill(queens[j],0);
        }
        operate(queens,0,last);
        return last;
    }
    public void operate (int[][] queens,int y,List<List<String>> last){
        if (y==queens.length){
            last.add(create(queens));
        }
        for (int x=0;x<queens.length;x++){
            if (!vaild(x,y,queens)){
                continue;
            }
            queens[y][x]=1;
            operate(queens,y+1,last);
            queens[y][x]=0;
        }
    }
    // y=x+c
    public boolean vaild(int x,int y,int[][] queens){
        for (int yy=0;yy<queens.length;yy++){
            for (int xx=0;xx<queens[0].length;xx++){
                if (queens[yy][xx]!=0){
                   if (x==xx||y==yy||x+y==xx+yy||x-y==xx-yy){
                       return false;
                   }
                }
            }
        }
        return true;
    }

    //create cheese
    public List<String> create(int[][] queens){
        List<String> list = new ArrayList<>();
        for (int n=0;n<queens.length;n++){
            StringBuilder sb = new StringBuilder();
            for (int k=0;k<queens[0].length;k++){
                if (queens[n][k]==0){
                    sb.append(".");
                }else{
                    sb.append("Q");
                }
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 4;
        Solution s = new Solution();
        System.out.println(s.solveNQueens(n).toString());
    }
}

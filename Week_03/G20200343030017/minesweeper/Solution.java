package week3.minesweeper;

import java.util.Arrays;

public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        recursion(board,click[0],click[1]);
        return board;
    }
    public void recursion(char[][] board,int y,int x){
        if (x<0||y<0){
            return;
        }
        if (x>board[y].length||y>board.length){
            return;
        }
        if(board[y][x]=='B'||(board[y][x]>='1'&&board[y][x]<='9')){
            return;
        }else{
            int bomb = 0;
            for (int n=x-1;n<=x+1;n++){
                for (int q=y-1;q<=y+1;q++){
                    if (n>=0&&q>=0&&n<board[y].length&&q<board.length){
                        if ((board[q][n]=='M'||board[q][n]=='X' )&&!(q==y&&n==x)){
                            bomb++;
                        }
                    }
                }
            }
            if (bomb==0){
                board[y][x]='B';
            }else{
                board[y][x]=Character.forDigit(bomb,10);
                return;
            }
            if (x-1>=0&&board[y][x]=='B'){
                recursion(board,y,x-1);
            }
            if (x+1<board[y].length&&board[y][x]=='B'){
                recursion(board,y,x+1);
            }
            if (y-1>=0&&board[y][x]=='B'){
                recursion(board,y-1,x);
            }
            if (y+1<board.length&&board[y][x]=='B'){
                recursion(board,y+1,x);
            }
            if (x-1>=0&&y-1>=0&&board[y][x]=='B'){
                recursion(board,y-1,x-1);
            }
            if (x+1<board[y].length&&y-1>=0&&board[y][x]=='B'){
                recursion(board,y-1,x+1);
            }
            if (x-1>=0&&y+1<board.length&&board[y][x]=='B'){
                recursion(board,y+1,x-1);
            }
            if (x+1<board[y].length&&y+1<board.length&&board[y][x]=='B'){
                recursion(board,y+1,x+1);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board ={{'E','E','E','E','E','E','E','E'},
                {'E','E','E','E','E','E','E','M'},
                {'E','E','M','E','E','E','E','E'},
                {'M','E','E','E','E','E','E','E'},
                {'E','E','E','E','E','E','E','E'},
                {'E','E','E','E','E','E','E','E'},
                {'E','E','E','E','E','E','E','E'},
                {'E','E','M','M','E','E','E','E'}};
        int[] click = {0,0};
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.updateBoard(board,click)));
    }
}

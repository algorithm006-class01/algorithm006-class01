package G20200343030379;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 130. 被围绕的区域
 *
 *给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 */



public class LeetCode_130_379 {
    public static void main(String[] args) {
        char[][] ch={{'1','1'},{'1','1'},{'1','0'}};
//        char[][] ch={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    }

    class UF{
        private int parent[];
        private int size[];
        private int count;

        public UF(int n,int m) {
            parent=new int[n*m];
            size=new int[n*m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    parent[i*m+j]=i*m+j;
                    size[i*m+j]=1;
                }
            }
        }

        public UF(char[][] board) {
            int n = board.length;
            int m = board[0].length;
            parent=new int[n*m];
            size=new int[n*m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    parent[i*m+j]=i*m+j;
                    size[i*m+j]=1;
                    if(board[i][j]=='0'){
                        count++;
                    }
                }
            }
        }

        //合并
        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP!=rootQ){

                if(size[rootP]>size[rootQ]){
                    parent[rootQ]=parent[rootP];
                    size[rootP]+=size[rootQ];

                }else{
                    parent[rootP]=parent[rootQ];
                    size[rootQ]+=size[rootP];
                }
               //暂时不用 count--;
            }
        }

        //查询父节点
        public int find(int x){
            while (x!=parent[x]){
                parent[x]=parent[parent[x]];
                x=parent[x];
            }
            return x;
        }

        //检查两个节点是否同一个父亲
        public boolean isConnected(int p,int q){
           return find(p)==find(q);
        }
    }

    /***
     * 并查集法
     *
     * 优秀题解：
     * （第三种解法：并查集）https://leetcode-cn.com/problems/surrounded-regions/solution/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/
     * 执行用时 : 14 ms , 在所有 Java 提交中击败了 10.36% 的用户
     * 内存消耗 : 41.9 MB , 在所有 Java 提交中击败了 37.60% 的用户
     * @param board
     */
    public void solve(char[][] board) {
        if(board.length==0) return;

        int n = board.length;
        int m = board[0].length;
        int endBorad=n*m-1;
        UF uf=new UF(n,m);

        //方向位
        int[][] distances={{-1,0},{1,0},{0,-1},{0,1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]=='O'){

                    int p=i*m+j;
                    //System.out.println(i+" "+j);
                    //把边界的'0'与右下角位置 合并
                    if(i==0 || i==n-1 || j==0 || j==m-1){
                        //System.out.println(i+"=="+j);
                        uf.union(p,endBorad);
                    }else{
                        //把边界内的'0'合并，上下左右

                        for (int[] d : distances) {
                            int px = i+d[0];
                            int qy = j+d[1];

                            //注意：这里也要检查临界节点是否是‘O’的情况，否则会把‘1’当前同一组
                            if(board[px][qy]!='O') continue;

                            //注意：这里要把==0的情况一起判定，也就是边界值的情况
                            if(px>=0 && px<n && qy>=0 && qy<m){
                                uf.union(p,px*m+qy);
                            }
                        }

                    }

                }

            }
        }


        //检查边界内的，并且不与右下角关联的填充为'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if(board[i][j]=='O' && !uf.isConnected(i*m+j,endBorad)){
                   board[i][j]='X';
               }
            }
        }
        return;

    }
}

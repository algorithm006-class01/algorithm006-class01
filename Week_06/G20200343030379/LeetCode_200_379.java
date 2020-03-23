package G20200343030379;

/**
 * 200. 岛屿数量
 *
 *给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 *  优秀题解：https://leetcode-cn.com/problems/number-of-islands/
 */



public class LeetCode_200_379 {
    public static void main(String[] args) {
        char[][] ch={{'1','1'},{'1','1'},{'1','0'}};
//        char[][] ch={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int i = new LeetCode_200_379().numIslands(ch);
        System.out.println(i);
    }


    class UF{
        private int count;
        private int[] size;
        private int[] parent;

        public UF(char grid[][]) {
            int n = grid.length;
            int m = grid[0].length;
            size=new int[n*m];
            parent=new int[n*m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    parent[i * m + j] = i * m + j;
                    size[i * m + j] = 1;
                    ///关键代码，容易错
                    if(grid[i][j]=='1'){
                        count++;
                    }
                }
            }
        }

        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);

            if(rootP!=rootQ){

                if(size[rootP]>size[rootQ]){
                    //Q的父节点指向P的父结点
                    parent[rootQ] = parent[rootP];
                    size[rootQ] += size[rootP];
                }else{
                    parent[rootP] = parent[rootQ];
                    size[rootP] += size[rootQ];
                }

                count--;
            }


        }

        public int find(int x){
            while (parent[x]!=x){
                parent[x]=parent[parent[x]];
                x=parent[x];
            }

            return x;
        }

        public int getCount() {
            return count;
        }
    }

    /**
     * 方向位写法
     * 优先：时间效率快了1秒
     *
     * 国外参考题解：https://leetcode.com/problems/number-of-islands/discuss/56354/1D-Union-Find-Java-solution-easily-generalized-to-other-problems
     *
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 25.47% 的用户
     * 内存消耗 : 42.2 MB , 在所有 Java 提交中击败了 5.02% 的用户
     */
    int[][] distance = {{-1,0},{1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        UF uf=new UF(grid);
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='1'){
                    grid[i][j]='0';
                    for (int[] d : distance) {
                        int p= i+d[0];
                        int q= j+d[1];
                        if(p>=0 && p<n && q>=0 && q<m && grid[p][q]=='1'){
                            uf.union(i*m+j,p*m+q);
                        }

                    }
                }
            }
        }
        return uf.getCount();
    }

    /**
     *
     * 参考题解：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/
     * @param grid
     * @return
     * 并查集
     * 执行用时 : 7 ms , 在所有 Java 提交中击败了 17.80% 的用户
     * 内存消耗 : 42.3 MB , 在所有 Java 提交中击败了 5.02% 的用户
     */
    public int numIslands2(char[][] grid) {
        if(grid.length==0) return 0;
        UF uf=new UF(grid);
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='1'){

                    int p= i*m+j;
                    grid[i][j]='0';
                    if (i>0 && grid[i-1][j]=='1'){
                        uf.union(p, (i-1)*m+j);
                    }
                    if(i+1<n && grid[i+1][j]=='1'){
                        uf.union(p, (i+1)*m+j);
                    }
                    if(j-1>0 && grid[i][j-1]=='1'){
                        uf.union(p, i*m+(j-1));
                    }
                    if(j+1<m && grid[i][j+1]=='1'){
                        uf.union(p, i*m+(j+1));
                    }
                }
            }
        }
        return uf.getCount();
    }
}

package G20200343030379;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Arrays;

/**
 *  547. 朋友圈
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 示例 2:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 注意：
 *
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 *
 *
 *  优秀题解：https://leetcode-cn.com/problems/friend-circles/
 *  国外优秀题解：https://leetcode.com/problems/friend-circles/discuss/101336/Java-solution-Union-Find
 */



public class LeetCode_547_379 {
    /**
     * 并查集写法，普通写法有点效率问题
     *
     * 执行用时 : 10 ms , 在所有 Java 提交中击败了 15.48% 的用户
     * 内存消耗 : 41.9 MB , 在所有 Java 提交中击败了 78.33% 的用户
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        int[] parent=new int[M.length];
        Arrays.fill(parent,-1);


        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if(M[i][j]==1 && i!=j){
                    union(parent,i,j);
                }
            }
        }

        int count=0;
        for (int i : parent) {
            //是父节点，说明存在一个组
            if(i==-1){
                count++;
            }
        }
        return count;
    }

    public void union(int[] parent,int i,int j){
        //寻找x轴的父节点位置
        int setx=find(parent,i);
        //寻找y轴的父节点位置
        int sety=find(parent,j);

        if(setx!=sety){
            parent[setx]=sety;
        }
    }


    public int find(int[] parent,int i){
        if(parent[i]==-1){
            return i;
        }
        return find(parent,parent[i]);
    }


    /**
     * 国外题解
     * 1、平衡二叉树
     * 2、路径压缩
     * @return
     */
    class UnionFind{
        private int count=0;
        private int[] parent,rank;

        public UnionFind(int n) {
            this.count = n;
            parent=new int[n];
            rank=new int[n];
            for (int i = 0; i < n; i++) {
                parent[i]=i;
            }
        }

        public int find2(int p){
            while (p!=parent[p]){
                parent[p]=parent[parent[p]];
                p=parent[p];
            }
            return p;
        }

        public void union(int p,int q){
            int rootP=find2(p);
            int rootQ=find2(q);

            if(rootP==rootQ) return;

            if(rank[rootQ] >rank[rootP]){
                parent[rootP]=rootQ;
            }else{
                parent[rootQ]=rootP;
                if(rank[rootP]==rank[rootQ]){
                    rank[rootP]++;
                }
            }
            count--;
        }

        public int count(){
            return count;
        }
    }

    public int findCircleNum2(int[][] M) {
        int n=M.length;
        UnionFind uf=new UnionFind(n);
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(M[i][j]==1) uf.union(i,j);
            }
        }
        return uf.count();
    }

    public static void main(String[] args) {
        char a='1';
        System.out.println(a);
    }

}

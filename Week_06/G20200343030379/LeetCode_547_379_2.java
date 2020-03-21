package G20200343030379;

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
 */



public class LeetCode_547_379_2 {

    /**
     * 优秀题解：https://leetcode-cn.com/problems/friend-circles/solution/union-find-suan-fa-xiang-jie-by-labuladong/
     * 1、平衡二叉树
     * 2、路径压缩
     *
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.93% 的用户
     * 内存消耗 : 41.5 MB , 在所有 Java 提交中击败了 78.93% 的用户
     * @return
     */
    class UF{
        private int count;
        private int[] size;
        private int[] parent;

        public UF(int n) {
            count=n;
            size=new int[n];
            parent=new int[n];
            for (int i = 0; i < n; i++) {
                //todo
                parent[i] = i;
                size[i] = 1;
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

    public int findCircleNum(int[][] M){
        UF uf=new UF(M.length);
        int n = M.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(M[i][j]==1){
                    uf.union(i,j);
                }
            }
        }
        return uf.getCount();
    }

}

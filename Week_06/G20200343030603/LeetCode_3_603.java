// 转化为 岛屿数目
//1、DFS
//2、BFS
//3、并查集 disjoint set
//  a. N --> 各自独立集合
//  b. 遍历好友关系矩阵 M：M[i][j] --> 合并
//  c. 看有多少孤立的集合
class Solution {

    //方法一：DFS 时间复杂度O(n^2) 空间复杂度O(n)
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            } 
        }
    }

    // //方法二：并查集 时间复杂度O(n^3) 空间复杂度O(n)
    // public int find(int parent[], int i){
    //     if (parent[i] == -1) {
    //         return i;
    //     }
    //     return find(parent, parent[i]);
    // }

    // public void union(int parent[], int x, int y) {
    //     int xset = find(parent, x);
    //     int yset = find(parent, y);
    //     if (xset != yset) {
    //         parent[xset] = yset;
    //     }
    // }

    // public int findCircleNum(int[][] M) {
    //     int[] parent = new int[M.length];
    //     Arrays.fill(parent, -1);
    //     for (int i = 0; i < M.length; i++) {
    //         for (int j = 0; j < M.length; j++) {
    //             if (M[i][j] == 1 && i != j) {
    //                 union(parent, i, j);
    //             }
    //         }
    //     }

    //     int count = 0;
    //     for (int i = 0; i < parent.length; i++) {
    //         if(parent[i] == -1) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }
}
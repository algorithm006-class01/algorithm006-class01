/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 *
 * https://leetcode-cn.com/problems/friend-circles/description/
 *
 * algorithms
 * Medium (55.16%)
 * Likes:    198
 * Dislikes: 0
 * Total Accepted:    29.6K
 * Total Submissions: 53.3K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是
 * C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j
 * 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 
 * [[1,1,0],
 * ⁠[1,1,0],
 * ⁠[0,0,1]]
 * 输出: 2 
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 
 * [[1,1,0],
 * ⁠[1,1,1],
 * ⁠[0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 
 * 
 * 注意：
 * 
 * 
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 * 
 * 
 */

// @lc code=start
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Arrays;
class Solution {
    // BFS （将矩阵看作图的邻接矩阵，关系是双向的，对称矩阵）
    // 时间复杂度：O(N^2) 对角线上部矩阵都需要访问
    // 空间复杂度：O(N) N为学生数量
    public int findCircleNum1(int[][] M) {
        int[] visited = new int[M.length];
        int circleNum = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < M.length; i++) {
            if (0 == visited[i]) { // 从一个未访问的节点进行扩散
                circleNum++;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = i + 1; j < M.length; j++) {  // 对称矩阵，只需处理对角线上部即可
                        if (1 == M[s][j] && 0 == visited[j]) {
                            queue.add(j);
                        }
                    }
                }
            }
        }

        return circleNum;
    }

    // DFS:递归版 （将矩阵看作图的邻接矩阵，关系是双向的，对称矩阵）
    // 时间复杂度：O(N^2) 对角线上部矩阵都需要访问
    // 空间复杂度：O(N) N为学生数量
    public int findCircleNum2(int[][] M) {
        int[] visited = new int[M.length];
        int circleNum = 0;
        for (int i = 0; i < M.length; i++) {
            if (0 == visited[i]) {
                dfs(M, visited, i);
                circleNum++;
            }
        }

        return circleNum;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) { // 对称矩阵，只需处理对角线上部即可
            if (0 == visited[j] && 1 == M[i][j]) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    // DFS: 非递归版 （将矩阵看作图的邻接矩阵，关系是双向的，对称矩阵）
    // 时间复杂度：O(N^2) 对角线上部矩阵都需要访问
    // 空间复杂度：O(N) N为学生数量
    public int findCircleNum3(int[][] M) {
        int[] visited = new int[M.length];
        int circleNum = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < M.length; i++) {
            if (0 == visited[i]) {
                circleNum++;
                stack.push(i);
                while(!stack.empty()) {
                    int s = stack.pop();
                    visited[s] = 1;
                    for (int j = i + 1; j < M.length; j++) {
                        if (0 == visited[j] && 1 == M[s][j]) {
                            stack.push(j);
                        }
                    }
                }
            }
        }

        return circleNum;
    }

    // 并查集解决方案
    // 时间复杂度：O(N^3) 遍历矩阵，并查集操作最坏时间时间复杂度O(n)
    // 空间复杂度：O(N) parent所占空间
    int find(int parent[], int i) {
        return -1 == parent[i]? i : find(parent, parent[i]);
    }

    void union(int parent[], int i, int j) {
        int iSet = find(parent, i);
        int jSet = find(parent, j);
        if (iSet != jSet)
            parent[iSet] = jSet;
    }

    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (1 == M[i][j])
                    union(parent, i, j);
            }
        }

        int circleNum = 0;
        for (int i = 0; i < M.length; i++) {
            if (-1 == parent[i])
                circleNum++;
        }
        return circleNum;
    }
    
}
// @lc code=end


package com.study.week06;

/**
 * @author Abner
 * @date 2020/3/22 23:12
 * @email songkd90@163.com
 * @description 朋友圈
 */
public class LeetCode_3_429 {

    /**
     * 1、DFS
     * @param M
     * @return
     */
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

    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    /**
     *
     * @param M
     * @return
     */
    public int findCircleNum2(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
            }

            while (!queue.isEmpty()) {
                int s = queue.remove();
                visited[s] = 1;

                for (int j = 0; j < M.length; j++) {
                    if (M[i][j] == 1 && visited[j] == 0) {
                        queue.add(j);
                    }
                }
            }

            count++;
        }

        return count;
    }

}

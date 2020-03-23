package Week_06;

public class Leetcode_547_001 {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int ret = 0;

        for(int i = 0; i < M.length; ++i) {
            if(!visited[i]) {
                dfs(M, visited, i);
                ret++;
            }
        }

        return ret;
    }

    private void dfs(int[][] m, boolean[] visited, int i) {
        for(int j = 0; j < m.length; ++j) {
            if(m[i][j] == 1 && !visited[j]) {
                visited[j] = true;

                dfs(m, visited, j);
            }
        }
    }
}

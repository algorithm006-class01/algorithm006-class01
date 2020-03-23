class Solution {
    class DisjoinSet {

    private int count = 0;
    private int[] parent;

    public DisjoinSet(int n) {
        parent = new int[n + 1];
        this.count = n;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq) return;
        parent[rootp] = rootq;
        count--;
    }

    public int getCount() {
        return count;
    }
}
    public int findCircleNum(int[][] M) {
        if (M.length == 0) {
            return 0;
        }
        DisjoinSet disjoinSet = new DisjoinSet(M[0].length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    disjoinSet.union(i, j);
                }
            }
        }
        return disjoinSet.getCount();
    }
}
class Solution {
    public int findCircleNum(int[][] M) {
        //corner case
        if (M == null || M.length == 0) return 0;
        
        //initialization: count = n, each id = id
        int m = M.length;
        int count = m;
        int[] roots = new int[m];
        for (int i = 0; i < m; i++) roots[i] = i; 
        
        //for loop and union find
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                //if there is an edge, do union find
                if (M[i][j] == 1) {
                    int root0 = find (roots, i);
                    int root1 = find (roots, j);
                    
                    if (root0 != root1) {
                        roots[root1] = root0;
                        count--;
                    }
                }
            }
        }
        
        //return count
        return count;
    }
    
    public int find (int[] roots, int id) {
        while (id != roots[id]) {
            id = roots[roots[id]];
        }
        return id;
    }
}


class Union {
    private int count;//联通个数

    private int[] parent;//x节点的父节点是parent[x]

    private int[] size;//定义每个节点下面节点个数

    public Union(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i=0;i<n;++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    //路径压缩：理解
    //如果x和parent[x]不相等，那么还没找到根节点
    //把x再往上提一层 指向parent[x]的上一个节点
    public int find(int x) {

        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x;
    }

    //连接p和q；
    //如果p的权重大一些，也即节点数目多一些，优先p做根节点，反之亦然
    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        //如果两个已经相等，返回不处理 即是同一个路径
        if (rootq == rootp) {
            return;
        }
        if (size[rootp] > size[rootq]) {
            parent[rootq] = rootp;
            size[rootp] += size[rootq];
        } else {
            parent[rootq] = rootp;
            size[rootq] += size[rootq];
        }
        --count;
    }

    public boolean isUnited(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        return rootp == rootq;
    }
    
    public int getCount() {
        return count;
    }

}

class LeetCode_547_505 {
    public int findCircleNum(int[][] M) {
        if (M == null) {
            return 0;
        }
        int len = M.length;
        if (len == 0) {
            return 0;
        }
        Union union = new Union(len);
        for (int i=0;i<len;++i) {
            for (int j=0;j<len;++j) {
                if (i != j && M[i][j] == 1) {
                    union.union(i, j);
                }
            }
        }
        return union.getCount();
    }
}
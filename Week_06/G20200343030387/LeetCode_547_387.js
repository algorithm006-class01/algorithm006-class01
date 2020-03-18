/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function (M) {
    const n = M.length
    const unionFind = new UnionFind(n)
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (M[i][j]) {
                unionFind.union(i, j)
            }
        }
    }
    return unionFind.count
};

class UnionFind {
    constructor(n) {
        // 初始化并查集
        this.count = n
        this.parent = []
        for (let i = 0; i < n; i++) {
            this.parent[i] = i
        }
    }

    // 找到节点的中心节点，并进行路径压缩
    find(i) {
        root = i
        // 不断往上找，直到找到中心节点
        while (this.parent[root] !== root) {
            root = this.parent[root]
        }
        // 路径压缩
        let x
        while (this.parent[i] !== i) {
            x = i
            i = this.parent[i]
            this.parent[x] = root
        }
        return root
    }

    // 合并节点集
    union(i, j) {
        const pi = this.find(i)
        const pj = this.find(j)
        if (pi === pj) return
        this.parent[pi] = pj
        this.count--
    }
}
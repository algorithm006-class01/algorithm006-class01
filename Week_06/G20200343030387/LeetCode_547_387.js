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
        this.size = []
        for (let i = 0; i < n; i++) {
            this.parent[i] = i
            this.size[i] = 1
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
        // 小树合并到大树上，尽量让合并后树的高度较小
        if (this.size[pi] > this.size[pj]) {
            this.parent[pi] = pj
            this.size[pi] += this.size[pj]
        } else {
            this.parent[pj] = pi
            this.size[pj] += this.size[pi]
        }
        this.count--
    }
}
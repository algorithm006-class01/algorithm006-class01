// 题目: 朋友圈
/**
 * 题目描述：
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，
那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，
否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

 */

 // 解题语言: javaScript

 // 解题

/**
 * 
 * @param {number[][]} M
 * @return {number} 
 */
var findCircleNum = function (M) {
    let n = M.length
    if (n == 0) return 0
    let count = n

    // 声明单集
    let parent = new Array(n)
    for (let i = 0; i < n; i++) parent[i] = i

    let findParent = (p) => {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]]
            p = parent[p]
        }
        return p
    }

    let union = (p, q) => {
        let rootP = findParent(p), rootQ = findParent(q)
        if (rootP === rootQ) return
        parent[rootP] = rootQ
        count--
    }

    for (let i = 0; i < n; i++ ) {
        for (let j = 0; j < n; j++) {
            if (M[i][j] === 1) union(i, j)
        }
    }
    return count
}


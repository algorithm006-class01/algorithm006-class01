/**
 * @param {number} n
 * @return {number}
 */
// 位运算 + DFS
var totalNQueens = function (n) {
    let res = 0
    const dfs = function (n, row, col, pie, na) {
        if (row >= n) return res++
        let bits = ~(col | pie | na) & ((1 << n) - 1) // 当前层能放皇后的位都赋值为1
        while (bits > 0) {
            let p = bits & -bits // 取最低位的1
            bits &= bits - 1 // 皇后放到最低位的1，相当于并把那一bit位赋值0
            dfs(n, row + 1, (col | p), (pie | p) << 1, (na | p) >> 1)
        }
    }
    dfs(n, 0, 0, 0, 0)
    return res
};

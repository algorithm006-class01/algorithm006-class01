// https://leetcode-cn.com/problems/n-queens-ii/

var totalNQueens = function(n) {
    let res = 0;
    const dfs = (n, row, cols, pie, na) => {
        if (row >= n) {
            res++;
            return;
        }
        let bits = (~(cols | pie | na)) & ((1 << n) - 1);
        while (bits) {
            let p = bits & -bits;
            bits = bits & (bits - 1);
            dfs(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1);
        }
    }
    dfs(n, 0, 0, 0, 0);
    return res;
};
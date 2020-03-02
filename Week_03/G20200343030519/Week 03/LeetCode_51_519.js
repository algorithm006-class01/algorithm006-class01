// https://leetcode-cn.com/problems/n-queens/

var solveNQueens = function(n) {
    let res = [], qChar = 'Q', emptyChar = '.';
    function doTry(row, tmp = []) {
        if (row === n) {
            res.push(tmp.map(colIndex => `${emptyChar.repeat(colIndex)}${qChar}${emptyChar.repeat(n-colIndex-1)}`));
            return;
        }
        for (let col = 0; col < n; col++) {
            if (tmp.some((colIndex, rowIndex) => {
                return colIndex === col ||
                rowIndex === row - col + colIndex ||
                rowIndex === row + col - colIndex
            })) {
                continue;
            }
            doTry(row + 1, [...tmp,col]);
        }
    }
    doTry(0, []);
    return res;
};
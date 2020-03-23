/*
* address:https://leetcode-cn.com/problems/valid-sudoku/submissions/
* */

const isValidSudoku = function(board) {
    let res = []
    for (let i = 0; i < 9; i++) {
        for (let j = 0; j < 9; j++) {
            let val = board[i][j]-1;
            if (val>=0 && val<=8) {
                let cur = 1 << j | 1 << i+9  | 1 <<  Math.floor(i/3)*3+Math.floor(j/3) + 18;
                let old = res[val];
                if ((old & cur) === 0) {
                    res[val] = old | cur
                } else {
                    return false

                }
            }

        }
    }
    return true
};

/**
 * @param {character[][]} board
 * @return {boolean}
 */
// 判断：
// 行中没有重复的数字。
// 列中没有重复的数字。
// 3 x 3 子数独内没有重复的数字
var isValidSudoku = function (board) {
    const rows = Array(9).fill(0).map(() => new Set())
    const cols = Array(9).fill(0).map(() => new Set())
    const boxes = Array(9).fill(0).map(() => new Set())
    for (let i = 0; i < 9; i++) {
        for (let j = 0; j < 9; j++) {
            let char = board[i][j]
            if (char !== '.') {
                let boxIndex = parseInt(parseInt(i / 3) * 3 + j / 3)
                if (rows[i].has(char) || cols[j].has(char) || boxes[boxIndex].has(char)) {
                    return false
                }
                rows[i].add(char)
                cols[j].add(char)
                boxes[boxIndex].add(char)
            }
        }
    }
    return true
};
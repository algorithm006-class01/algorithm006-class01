/**
 * @param {number} n
 * @return {string[][]}
 */
// 递归法
// 皇后在每一行都会有n个列可选，相当于状态树的每一层都有n个分叉；
// 走下一个分叉前需要判断攻击范围，每次成功都存储当前所在的列，行数则为当时遍历到的状态树层次，也是存入数组元素的序号；
// 若走到了最底层，则表示当前存储的状态符合条件；
var solveNQueens = function (n) {
    const res = []
    const cols = new Set() // 垂直线的攻击位置
    const pies = new Set() // 向左对角线的攻击位置
    const nas = new Set() // 向右对角线的攻击位置
    // 递归生成皇后的位置
    const recurison = function (row, queens) {
        if (row >= n) {
            // 由于queens在reverse会被修改，所以这里clone一份
            res.push(queens.slice(0))
            return
        }
        // 遍历列
        for (let col = 0; col < n; col++) {
            // 判断是否在攻击范围，是则continue
            if (cols.has(col) || pies.has(col + row) || nas.has(col - row)) {
                continue
            }
            cols.add(col)
            pies.add(col + row)
            nas.add(col - row)
            queens.push(col)

            // drill down
            recurison(row + 1, queens)

            // reverse status
            queens.pop()
            cols.delete(col)
            pies.delete(col + row)
            nas.delete(col - row)
        }
    }
    // 生成棋盘
    const generateCheckerboard = function () {
        return res.map(queens => {
            return queens.map(q => {
                return Array(n).fill().map((k, i) => {return i === q ? 'Q' : '.'}).join('')
            })
        })
    }
    recurison(0, [])
    return generateCheckerboard()
};
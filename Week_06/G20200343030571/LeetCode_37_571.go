package main

/*
 * @lc app=leetcode.cn id=37 lang=golang
 *
 * [37] 解数独
 *
 * https://leetcode-cn.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (60.03%)
 * Likes:    351
 * Dislikes: 0
 * Total Accepted:    22K
 * Total Submissions: 36.4K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 空白格用 '.' 表示。
 *
 *
 *
 * 一个数独。
 *
 *
 *
 * 答案被标成红色。
 *
 * Note:
 *
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 *
 *
 */

// @lc code=start
func solveSudoku(board [][]byte) {
	if board == nil || len(board) == 0 {
		return
	}
	dfsSolve(board)
}

func dfsSolve(board [][]byte) bool {
	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			if board[i][j] != '.' {
				continue
			}
			for n := '1'; n <= '9'; n++ { //用rune直接转byte,如果用int那么结果会出乱码

				board[i][j] = byte(n)
				if dfsSolve(board) {
					return true
				}
				board[i][j] = byte('.')
			}
			return false
		}
	}
	return true
}

func isValid(n byte, i, j int, board [][]byte) bool {
	for k := 0; k < 9; k++ {
		if board[i][k] == byte(n) || board[k][j] == byte(n) {
			return false
		}
		if board[3*(i/3)+k/3][3*(j/3)+k%3] == byte(n) { //?
			return false
		}
	}
	return true
}

/* func main() {
	i := 8
	var b byte = byte(i)
	fmt.Printf("byte %#v \n int %d \n", b, b)
	return
}
*/
// @lc code=end

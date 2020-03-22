package main
/*
	51. N 皇后

	n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，
	并且使皇后彼此之间不能相互攻击。
	给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

	每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

	示例:

	输入: 4
	输出: [
	 [".Q..",  // 解法 1
	  "...Q",
	  "Q...",
	  "..Q."],

	 ["..Q.",  // 解法 2
	  "Q...",
	  "...Q",
	  ".Q.."]
	]
	解释: 4 皇后问题存在两个不同的解法。
*/
/*
	参照国际站的代码写的。因为golang中似乎没有优雅的给string“向后拼接N个字符”
	的操作，所以直接在回溯过程中将答案打印好，整体代码会比较简洁。

	candidate的类型为[][]rune,这里利用里[]rune类型可以和string类型相互转换。
	因此可以用操作数组的方式，方便的修改字符串中的某个字符
*/
func solveNQueens(n int) [][]string {
	res := make([][]string, 0)
	candidate := make([][]rune, n)

	col := make([]bool, n)
	pie := make([]bool, 2*n)
	na := make([]bool, 2*n)

	for i := range candidate {
		candidate[i] = make([]rune, n)
		for j := range candidate[i] {
			candidate[i][j] = '.'
		}
	}

	dfs(candidate,0, n, &res, col, pie, na)
	return res
}

func dfs(candidate [][]rune, row, n int, res *[][]string, col, pie, na []bool) {
	 if row >= n {
		 var arr []string
		 for _, v := range candidate {
			 arr = append(arr, string(v))
		 }
		 *res = append(*res, arr)
		 return
	 }

	 for i := 0; i < n; i++ {
	 	curPie := row + i
	 	curNa := n - i + row
	 	curCol := i
	 	if col[curCol] || na[curNa] || pie[curPie] {
	 		continue
		}

		candidate[row][i] = 'Q'
	 	col[curCol], na[curNa], pie[curPie] = true, true, true
	 	dfs(candidate, row+1, n, res, col, pie, na)

	 	candidate[row][i] = '.'
	 	col[curCol], na[curNa], pie[curPie] = false, false, false
	}
}

package main

/*
 * @lc app=leetcode.cn id=52 lang=golang
 *
 * [52] N皇后 II
 *
 * https://leetcode-cn.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (77.41%)
 * Likes:    102
 * Dislikes: 0
 * Total Accepted:    18.8K
 * Total Submissions: 24.1K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 *
 */

// @lc code=start

func totalNQueens(n int) int {
	if n <= 0 {
		return 0
	}

	//col, pie, na := make([]bool, n), make([]bool, 2*n), make([]bool, 2*n)
	res := 0
	//dfsFind1(0, n, col, pie, na, &res)
	dfsFind2(0, n, 0, 0, 0, &res)
	return res
}

// dfs 数组判重法
func dfsFind1(curRow, len int, col, pie, na []bool, res *int) {
	if curRow >= len {
		*res++
		return
	}

	for i := 0; i < len; i++ {
		c, p, n := i, i+curRow, i-curRow+len
		if col[c] || pie[p] || na[n] {
			continue
		}

		col[c], pie[p], na[n] = true, true, true
		dfsFind1(curRow+1, len, col, pie, na, res)
		col[c], pie[p], na[n] = false, false, false
	}
	return
}

//dfs 位运算判重法
func dfsFind2(curRow, len, col, pie, na int, res *int) {
	if curRow >= len {
		*res++
		return
	}

	//每个掩码里初始是用0表示空位，但为了计算，要先取反获取用1表示空位的bits位
	bits := (^(col | pie | na)) & ((1 << len) - 1)

	for bits > 0 {
		p := bits & -bits  //取最低的1位,表示从右到左依次取出可以放入皇后的位置
		bits &= (bits - 1) //最低位的1置为0，表示在p的位置放上皇后

		//注意对于bits而言0表示放上皇后,但对col,pie,na来说置1表示放上皇后（的攻击范围）
		dfsFind2(curRow+1, len, col|p, (pie|p)<<1, (na|p)>>1, res)
	}
	return
}

/*
func main() {
	res := totalNQueens(4)
	fmt.Println(res)
}
*/
// @lc code=end

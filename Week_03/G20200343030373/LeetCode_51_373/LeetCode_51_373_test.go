//https://leetcode-cn.com/problems/n-queens/
package n_queens_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestNQueens(t *testing.T) {
	t.Log("N-Queens: DFS Prune")
	expect := [][]string{
		{".Q..",
			"...Q",
			"Q...",
			"..Q."},
		{"..Q.",
			"Q...",
			"...Q",
			".Q.."},
	}
	//[[1 3 0 2] [2 0 3 1]]
	assert.Equal(t, expect, solveNQueens(4))
}

//从第一行开始
//循环列并试图在每个列中放置皇后
//在`坐标1`位置放置皇后
//记忆化排除行、列、撇、捺的位置
//如果所有的行都被考虑过了，递归终止，找到其中一个解
//否则，继续考虑下一行皇后位置
//回溯：将`坐标1`位置的皇后移除
//O(n!), O(n)
func solveNQueens(n int) [][]string {
	if n == 0 {
		return [][]string{}
	}

	var res [][]int //一个结果：从每一行上取一个列坐标
	//行，一行只能有一个皇后
	//列，一列只能有一个皇后，只需按列循环，将列号进行记忆化（map, key是列号，value是是否被占用）
	//撇，行号 + 列号 = 常数，将其作为撇的坐标进行记忆化
	//捺，行号 - 列号 = 常数，将其作为捺的坐标进行记忆化
	var rows []int                  //行，二维数组的第一维
	cols := make(map[int]bool, n)   //列，记录'|'方向上的占用情况
	pies := make(map[int]bool, 2*n) //撇，记录'/'方向上的占用情况
	nas := make(map[int]bool, 2*n)  //捺，记录'\'方向上的占用情况
	//递归，传入的是值时，回归到本层不会被修改；传入的是引用时，每一层的修改都有效
	dfs(n, rows, cols, pies, nas, &res)
	return generateResult(res, n)
}

func dfs(n int, rows []int, cols, pies, nas map[int]bool, res *[][]int) {
	row := len(rows)
	//终止条件：访问的row行已经大于等于n
	if row == n {
		//go的切片是地址，往数组中添加要复制新的，否则会被后续操作修改
		//如果直接append rows，leetcode Not AC
		tmp := make([]int, n)
		copy(tmp, rows)
		*res = append(*res, tmp)
		return
	}
	//对于每一行遍历所有列
	for col := 0; col < n; col++ {
		//查看该列是否被占用，记录在set中
		if cols[col] || pies[row+col] || nas[row-col] {
			continue
		}
		//标记占用，更新set表示被占用，不能放置皇后
		cols[col], pies[row+col], nas[row-col] = true, true, true
		//递归到下一行
		dfs(n, append(rows, col), cols, pies, nas, res)
		//回溯，解除标记不影响下次递归使用
		cols[col], pies[row+col], nas[row-col] = false, false, false
	}
}

func generateResult(res [][]int, n int) (result [][]string) {
	for _, v := range res {
		var s []string
		for _, val := range v {
			str := ""
			for i := 0; i < n; i++ {
				if i == val {
					str += "Q"
				} else {
					str += "."
				}
			}
			s = append(s, str)
		}
		result = append(result, s)
	}
	return
}

//https://leetcode-cn.com/problems/n-queens-ii/

package n_queens_2_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestNQueens2(t *testing.T) {
	t.Log("N-Queens 2: DFS Prune + Bitwise")
	assert.Equal(t, 0, totalNQueens(0))
	assert.Equal(t, 2, totalNQueens(4))
}

//1. 递归终止条件：row行数扫描结束；则肯定找到了一个，需要加1
//2. 得到空位：`bits := (^(col | pie | na)) & ((1<<uint(n))-1)`
//- 把列、撇、捺被皇后攻击的位置，位置即为1，或起来(col | pie | na)，则得到的数字中0的位置就是空位
//- 将这个数字取反，即把空位用1来显性出来
//- 假设是8皇后，那么9～31位也被取反成1了，要重置成0
//- 所以需要与((1<<uint(n))-1)取与，因为：1左移8位，再减1，则得到的数字：0～8位是1，9～31位是0
//3. 遍历所有空位
//- 取位置排在最后的那一个空位，因为之前已经把空位显性为1，所以通过 `bit = bits & -bits` 得到最低位的1
//- 取到了空位之后，在此基础上进行**DFS**搜索，搜索完之后，要**回溯**，因为取到了空位为显性的最低位的1，则将这个1打掉即可，即`bits = bits & (bits-1)`
//- 向下走一层进行DFS，列、撇、捺需要受bit的影响进行记录更新
//-- 行：row+1
//-- 列：col|bit
//-- 撇：(pie|bit)<<1
//-- 捺：(na|bit)>>1
func totalNQueens(n int) int {
	if n == 0 {
		return 0
	}

	res := 0
	dfs(n, 0, 0, 0, 0, &res)
	return res
}

func dfs(n, row, col, pie, na int, res *int) {
	if row >= n {
		*res++
		return
	}

	bits := (^(col | pie | na)) & ((1 << uint(n)) - 1)
	for bits != 0 {
		bit := bits & -bits
		dfs(n, row+1, col|bit, (pie|bit)<<1, (na|bit)>>1, res)
		bits = bits & (bits - 1)
	}
}

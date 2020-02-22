// https://leetcode-cn.com/problems/combinations/
package leetcode

func combine(n int, k int) [][]int {
	return new(comSt).findAllComb(n, k, 1, make([]int, 0, k)).res
}

type comSt struct {
	res [][]int
}

func (st *comSt) findAllComb(n int, k int, position int, memo []int) *comSt {
	if len(memo) == k {
		s := make([]int, k)
		copy(s, memo)
		st.res = append(st.res, s)
		return st
	}
	for i := position; i <= n; i++ {
		slice := append(memo, i)
		st.findAllComb(n, k, i+1, slice[:])
	}
	return st
}

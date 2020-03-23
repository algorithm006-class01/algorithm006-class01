//https://leetcode-cn.com/problems/friend-circles/
package leetcode

func findCircleNum(M [][]int) int {
	count := len(M)
	ds := makeDisjointSet(count)
	for i := 0; i < len(M); i++ {
		for j := 0; j < i; j++ {
			if M[i][j] == 1 {
				if union(ds, i, j) {
					count--
				}
			}
		}
	}
	return count

}

func makeDisjointSet(size int) []int {
	s := make([]int, size)
	for i := 0; i < size; i++ {
		s[i] = i
	}
	return s
}

func find(ds []int, v int) int {
	for ds[v] != v {
		ds[v] = ds[ds[ds[v]]]
		v = ds[v]
	}
	return v
}

func union(ds []int, p, q int) bool {
	proot := find(ds, p)
	qroot := find(ds, q)
	if proot == qroot {
		return false
	}
	ds[proot] = qroot
	return true
}

// https://leetcode-cn.com/problems/merge-intervals/
package leetcode

func merge(intervals [][]int) (ret [][]int) {
	sort.SliceStable(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	st := new(stack)
	for _, arr := range intervals {
		for i, v := range arr {
			switch st.size() {
			case 0, 1:
				st.push(v)
			case 2:
				if v > st.peek() {
					if i == 0 {
						a, b := st.pop(), st.pop()
						ret = append(ret, []int{b, a})
						st.push(v)
					} else {
						st.pop()
						st.push(v)
					}
				}
			}
		}
	}
	if st.size() != 0 {
		a, b := st.pop(), st.pop()
		ret = append(ret, []int{b, a})
	}
	return
}

type stack struct{ data []int }

func (st *stack) peek() int {
	return st.data[len(st.data)-1]
}

func (st *stack) pop() (v int) {
	size := len(st.data)
	v = st.data[size-1]
	st.data = st.data[:size-1]
	return
}
func (st *stack) push(v int) {
	st.data = append(st.data, v)
}
func (st *stack) size() int { return len(st.data) }

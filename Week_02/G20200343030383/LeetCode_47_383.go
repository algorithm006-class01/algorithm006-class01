// https://leetcode-cn.com/problems/permutations-ii/
package leetcode

func permuteUnique(nums []int) [][]int {
	return new(pst).doPermute(nums, 0, make([]int, 0, len(nums))).res
}

type pst struct {
	res [][]int
}

func (p *pst) addRes(a []int) *pst {
	s := make([]int, len(a))
	copy(s, a)
	p.res = append(p.res, s)
	return p
}
func (p *pst) doPermute(nums []int, start int, memo []int) *pst {
	if start >= len(nums) {
		return p.addRes(memo)
	}
	dup := make(map[int]bool)
	for i := start; i < len(nums); i++ {
		if dup[nums[i]] {
			continue
		}
		dup[nums[i]] = true
		nums[start], nums[i] = nums[i], nums[start]
		p.doPermute(nums, start+1, append(memo, nums[start]))
		nums[i], nums[start] = nums[start], nums[i]
	}
	return p
}

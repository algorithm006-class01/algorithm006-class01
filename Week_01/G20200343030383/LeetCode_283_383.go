// https://leetcode-cn.com/problems/move-zeroes/submissions/
package leetcode

func moveZeroes(nums []int) {
	var zeroCount int
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			zeroCount++
		} else if j := i - zeroCount; i != j {
			nums[j] = nums[i]
			nums[i] = 0
		}
	}
}

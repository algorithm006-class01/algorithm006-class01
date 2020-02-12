// https://leetcode-cn.com/problems/rotate-array/
package leetcode

func rotate(nums []int, k int) {
	if len(nums) == 0 || k == 0 || k%len(nums) == 0 {
		return
	}
	k = k % len(nums)
	reverseSlice(nums, 0, len(nums)-1)
	reverseSlice(nums, 0, k-1)
	reverseSlice(nums, k, len(nums)-1)
}

func reverseSlice(nums []int, i, j int) {
	for i < j {
		nums[i], nums[j] = nums[j], nums[i]
		i++
		j--
	}
}

/*
  1. save start element for every loop round, keep its positon i
  2. find who-should-take-my-positon e.g. position j
  3. set j's value to i's position and set i=j (if j is not start position)
  4. set start element to i's position and start next round (if j is start position)
  5. exit if move len(nums) times
*/
func rotate2(nums []int, k int) {
	size := len(nums)
	if size == 0 || k == 0 || k%size == 0 {
		return
	}
	k = k % size
	start, startV := -1, 0
	for cnt, i := 0, 0; cnt < size; cnt++ {
		if start == -1 {
			start = i
			startV = nums[i]
		}
		j := whoShouldTakeMyPosition(size, k, i)
		if j == start {
			nums[i] = startV
			start = -1
			i++
		} else {
			nums[i] = nums[j]
			i = j
		}
	}
}

func whoShouldTakeMyPosition(size, k, i int) int {
	return (i - k + size) % size
}

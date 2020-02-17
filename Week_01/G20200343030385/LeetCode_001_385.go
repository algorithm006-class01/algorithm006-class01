func twoSum(nums []int, target int) []int {
	var b []int
	for j := 0; j < len(nums);j ++  {
		var b []int
		b = append(b, j)
		c := target - nums[j]
		for i := j + 1; i < len(nums);i ++  {

			if c == nums[i]{
				b = append(b, i)
				return b
			}
		}
	}
	return b
}

package G20200343030501

func numDecodings(s string) int {
	var nums []int
	base := int('0')
	for _, digit := range s {
		nums = append(nums, int(digit)-base)
	}
	length := len(nums)
	lastOne := 0
	lastTwo := 0
	if nums[length - 1] == 0 {
		lastOne = 0
	} else {
		lastOne = 1
	}
	if length == 1 {
		return lastOne
	}
	lastTwo = lastOne
	if nums[length-2] == 0 {
		lastOne = 0
	} else if exists(nums, length - 2) {
		lastOne = lastTwo + 1
	}
	for index := length - 3; index >= 0; index-- {
		if nums[index] == 0 {
			lastTwo = lastOne
			lastOne = 0
			continue
		}
		current := lastOne
		if exists(nums, index) {
			current += lastTwo
		}
		lastTwo = lastOne
		lastOne = current
	}
	return lastOne
}

func exists(nums []int, index int) bool {
	return nums[index] * 10 + nums[index + 1] <= 26
}

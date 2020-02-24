package G20200343030501

func plusOne(digits []int) []int {
	len := len(digits)
	addEnd := 1
	i := len - 1
	for ; i >= 0; i-- {
		currentNum := digits[i]
		if currentNum + addEnd == 10 {
			addEnd = 1
			digits[i] = 0
		} else {
			digits[i] += 1
			addEnd = 0
			break
		}
	}
	var result []int
	if i == -1 && addEnd == 1 {
		result = append([]int{1}, digits...)
	} else {
		result = digits
	}
	return result
}

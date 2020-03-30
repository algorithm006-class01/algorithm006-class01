package G20200343030501

func hammingWeight(num uint32) int {
	count := 0
	for {
		if num != 0 {
			count++
			num = num & (num - 1)
		} else {
			break
		}
	}
	return count
}
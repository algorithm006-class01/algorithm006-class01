package G20200343030501

func firstUniqChar(s string) int {
	var charCountMap = make(map[int32]int)

	for _, char := range s {
		charCountMap[char] += 1
	}
	for index, char := range s {
		if charCountMap[char] == 1 {
			return index
		}
	}
	return -1
}

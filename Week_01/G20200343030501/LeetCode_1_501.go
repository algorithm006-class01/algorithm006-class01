package G20200343030501

func twoSum(nums []int, target int) []int {
	indexMap := make(map[int]int)
	for index, value := range nums {
		completion := target - value
		completionIndex, exist := indexMap[completion]
		if exist {
			if index > completionIndex {
				return []int{completionIndex, index}
			} else {
				return []int{index, completionIndex}
			}
		} else {
			indexMap[value] = index
			continue
		}
	}
	return []int{0, 0}
}
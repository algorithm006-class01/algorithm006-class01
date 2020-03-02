package G20200343030501

func maxProfit(prices []int) int {
	sum := 0
	length := len(prices)
	lowerIndex := 0
	upperIndex := 0
	counted := true
	for index := 0; index < length; index++ {
		if prices[index] >= prices[upperIndex] {
			upperIndex = index
			counted = false
		} else {
			sum += prices[upperIndex] - prices[lowerIndex]
			lowerIndex = index
			upperIndex = index
			counted = true
		}
	}
	if !counted {
		sum += prices[upperIndex] - prices[lowerIndex]
	}
	return sum
}
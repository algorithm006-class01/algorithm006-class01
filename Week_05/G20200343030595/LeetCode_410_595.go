package main

func splitArray(nums []int, m int) int {
	lBound, rBound := 0, 0
	for _, v := range nums {
		rBound += v
		if v > lBound {
			lBound = v
		}
	}

	for lBound < rBound {
		mid := (lBound + rBound) / 2
		cut := getCutSize(nums, mid)
		if cut > m {
			lBound = mid+1
		} else {
			rBound = mid // can not be mid-1, one more cut doesn't mean less result
		}
	}
	return lBound
}

func getCutSize(nums []int, max int) int {
	cutSize, curValue := 1, 0 // cutSize init value is 1, not 0
	for _, v := range nums {
		if curValue + v <= max {
			curValue += v
		} else {
			curValue = v
			cutSize++
		}
	}
	return cutSize
}

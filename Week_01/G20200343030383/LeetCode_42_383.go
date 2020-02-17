// https://leetcode.com/problems/trapping-rain-water/submissions/
package leetcode

func trap(height []int) int {
	left, right := 0, len(height)-1
	var maxLeft, maxRight int
	var sum int
	for left <= right {
		if height[left] <= height[right] {
			if maxLeft >= height[left] {
				sum += maxLeft - height[left]
			} else {
				maxLeft = height[left]
			}
			left++
		} else {

			if maxRight >= height[right] {
				sum += maxRight - height[right]
			} else {
				maxRight = height[right]
			}
			right--
		}
	}
	return sum
}

func trap2(height []int) int {
	size := len(height)
	if size < 3 {
		return 0
	}
	leftHighest, righHighest := make([]int, size), make([]int, size)
	leftHighest[0] = height[0]
	righHighest[size-1] = height[size-1]
	for i := 1; i < size-1; i++ {
		leftHighest[i] = max(height[i], leftHighest[i-1])
		j := size - 1 - i
		righHighest[j] = max(height[j], righHighest[j+1])
	}

	var count int
	for i := 1; i < size-1; i++ {
		count += max(min(leftHighest[i-1], righHighest[i+1])-height[i], 0)
	}
	return count
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

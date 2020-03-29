package main

func climbStairs(n int) int {
	switch n {
	case 1, 2:
		return n

	default:
		nums := make([]int, n+1)
		nums[1] = 1
		nums[2] = 2
		for i := 3; i <= n; i++ {
			nums[i] = nums[i-1] + nums[i-2]
		}
		return nums[n]
	}
}

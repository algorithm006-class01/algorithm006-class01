package main

func maxCoins(nums []int) int {
	n := len(nums)
	nums = append([]int{1}, append(nums, 1)...)
	c := make([][]int, n+2)
	for i := range c {
		c[i] = make([]int, n+2)
	}
	for l := 1; l <= n; l++ {
		for i := 1; i <= n-l+1; i++ {
			j := i+l-1
			for k := i; k <= j; k++ {
				c[i][j] = max(c[i][j], c[i][k-1] + nums[i-1]*nums[k]*nums[j+1] + c[k+1][j])
			}
		}
	}
	return c[1][n]
}

func max(a, b int) int {
	if a > b { return a }
	return b
}

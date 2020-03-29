package G20200343030501

func climbStairs(n int) int {
	if n == 1 {
		return 1
	}
	container := make([]int, n + 1)
	container[1] = 1
	container[2] = 2
	for i := 3; i <= n; i++ {
		container[i] = container[i - 1] + container[i - 2]
	}
	return container[n]
}
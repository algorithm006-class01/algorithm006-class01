//https://leetcode-cn.com/problems/climbing-stairs/description/
package climb_stair_test

import (
	"github.com/stretchr/testify/assert"
	"math"
	"testing"
)

func TestDP(t *testing.T) {
	t.Log("Climbing Stairs: DP Fibonacci")
	//题目描述，给定n是一个正整数，即n从1开始
	//n: 1, 2, 3, 4, 5...
	//f: 1, 2, 3, 5, 8...
	//区别Fibonacci, 爬楼梯n从1开始，斐波那次n从0开始；爬楼梯题目的 i和n 分别要比斐波那契 多1
	assert.Equal(t, 2, climbStairs(2))
	assert.Equal(t, 5, climbStairs(4))
	assert.Equal(t, 5, resOriginal(4))
	assert.Equal(t, 5, resMemoOut(4))
	assert.Equal(t, 5, resMemoIn(4))
	assert.Equal(t, 5, dpOriginal(4))
	assert.Equal(t, 5, dpShrink(4))
	assert.Equal(t, 5, formula(4))
	assert.Equal(t, 5, matrix(4))
}

func climbStairs(n int) int {
	return matrix(n)
}

//1. original recursion
//Not AC, TimeOut
func resOriginal(n int) int {
	if n <= 2 { //区别Fibonacci
		return n
	}
	return resOriginal(n-1) + resOriginal(n-2)
}

//2.1. recursion + memory
var hash = make(map[int]int)

func resMemoOut(n int) int {
	if n <= 2 {
		return n
	}
	if _, ok := hash[n]; !ok {
		hash[n] = resMemoOut(n-1) + resMemoOut(n-2)
	}
	return hash[n]
}

//2.2. recursion + memory + drill down the memory
func resMemoIn(n int) int {
	hash := make(map[int]int)
	return resMemo(n, hash)
}

func resMemo(n int, hash map[int]int) int {
	if n <= 2 {
		hash[n] = n
		return hash[n]
	}
	if _, ok := hash[n]; !ok {
		hash[n] = resMemo(n-1, hash) + resMemo(n-2, hash)
	}
	return hash[n]
}

//3. dp original
func dpOriginal(n int) int {
	if n <= 2 {
		return n
	}
	dp := make([]int, n+1)
	dp[1], dp[2] = 1, 2       //区别Fibonacci
	for i := 3; i <= n; i++ { //区别Fibonacci
		dp[i] = dp[i-1] + dp[i-2]
	}
	return dp[n]
}

//4. dp + shrink space
func dpShrink(n int) int {
	if n <= 2 {
		return n
	}
	low, high := 1, 2
	for i := 3; i <= n; i++ {
		high, low = high+low, high
	}
	return high
}

//5. formula
func formula(n int) int {
	goldenRation := (1 + math.Sqrt(5)) / 2
	res := math.Pow(goldenRation, float64(n+1)) / math.Sqrt(5) //区别 Fibonacci
	return int(math.Round(res))
}

//6. matrix
func matrix(n int) int {
	if n <= 2 {
		return n
	}

	A := [2][2]int{
		{1, 1},
		{1, 0},
	}

	A = pow(A, n) //区别Fibonacci
	return A[0][0]
}

func pow(A [2][2]int, n int) [2][2]int {
	if n <= 1 {
		return A
	} //递归终止条件，n<=1；与Power n==0 不同

	R := pow(A, n/2)

	if n&1 == 1 {
		return mul(A, mul(R, R))
	}
	return mul(R, R)
}

func mul(A, B [2][2]int) [2][2]int {
	x := A[0][0]*B[0][0] + A[0][1]*B[1][0]
	y := A[0][0]*B[0][1] + A[0][1]*B[1][1]
	z := A[1][0]*B[0][0] + A[1][1]*B[0][1]
	w := A[1][0]*B[0][1] + A[1][1]*B[1][1]

	A[0][0] = x
	A[0][1] = y
	A[1][0] = z
	A[1][1] = w

	return A
}

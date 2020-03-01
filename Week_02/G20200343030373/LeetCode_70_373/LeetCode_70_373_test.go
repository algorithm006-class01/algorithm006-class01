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

	//升级1：每次可以走1，2，3步
	assert.Equal(t, 4, dpStep3(3))
	assert.Equal(t, 7, dpStep3(4))
	assert.Equal(t, 13, dpStep3(5))
	assert.Equal(t, 24, dpStep3(6))

	//升级2：每次可以走1，2，3步，前后走的步数不能重复
	assert.Equal(t, 3, dpStep3NoRepeat1(3))
	assert.Equal(t, 3, dpStep3NoRepeat1(4))
	assert.Equal(t, 4, dpStep3NoRepeat1(5))
	assert.Equal(t, 8, dpStep3NoRepeat2(6))
	assert.Equal(t, 9, dpStep3NoRepeat2(7))

	//升级3：每次走的步数是在一个数组里定义的，类似coin change; 且不重复
	//步数数组首先要去重(必须)，然后最好排序(非必须)
	//直白版 与 美化版
	steps := []int{1, 2, 3}
	assert.Equal(t, 3, dpSteps(3, steps))
	assert.Equal(t, 3, dpSteps(4, steps))
	assert.Equal(t, 4, dpSteps(5, steps))
	assert.Equal(t, 8, dpSteps2(6, steps))
	assert.Equal(t, 9, dpSteps2(7, steps))

	//升级4：每次可以走1，2，3，..., m步，m<=n
	//纯记忆：前m阶初始值是2^(m-1)种，后面m+1是dp[i] = dp[i-1]*2 - dp[i-m-1]
	//https://www.cnblogs.com/wxdjss/p/5450749.html
	assert.Equal(t, 5, dpStepM(4, 2))
	assert.Equal(t, 29, dpStepM(6, 4))
	assert.Equal(t, 31, dpStepM(6, 5))
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

//升级1：每次可以走1，2，3步
func dpStep3(n int) int {
	if n <= 1 {
		return 1
	}
	dp := make([]int, n+1)
	dp[1], dp[2] = 1, 2
	dp[3] = 1 + dp[2] + dp[1]
	for i := 4; i <= n; i++ {
		dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
	}
	return dp[n]
}

//升级2：前后走的步数不能重复
//升维，上一步走的步数
func dpStep3NoRepeat1(n int) int {
	if n == 1 {
		return 1
	}
	dp := make([][4]int, n+1)
	dp[1][1], dp[1][2], dp[1][3] = 1, 0, 0
	dp[2][1], dp[2][2], dp[2][3] = 0, 1, 0
	dp[3][1], dp[3][2], dp[3][3] = 1, 1, 1 //之前走了1步上来的第3个台阶，且不重复，的情况种类是1种
	for i := 4; i <= n; i++ {              //遍历每一层台阶
		for last := 1; last <= 3; last++ { //以last步到达的当前台阶
			dp[i][last] = dp[i-last][1] + dp[i-last][2] + dp[i-last][3] - dp[i-last][last]
		}
	}
	return dp[n][1] + dp[n][2] + dp[n][3]
}

func dpStep3NoRepeat2(n int) int {
	if n == 1 {
		return 1
	}
	dp := make([][4]int, n+1)
	dp[1][1], dp[1][2], dp[1][3] = 1, 0, 0
	dp[2][1], dp[2][2], dp[2][3] = 0, 1, 0
	dp[3][1], dp[3][2], dp[3][3] = 1, 1, 1 //之前走了1步上来的第3个台阶，且不重复，的情况种类是1种
	for i := 4; i <= n; i++ {              //遍历每一层台阶
		for last := 1; last <= 3; last++ { //以last步到达的当前台阶
			//dp[i][last] = dp[i-last][1] + dp[i-last][2] + dp[i-last][3] - dp[i-last][last]
			for pre := 1; pre <= 3; pre++ { //以pre步到达的i-last层台阶
				if last == pre {
					continue
				}
				dp[i][last] += dp[i-last][pre]
			}
		}
	}
	return dp[n][1] + dp[n][2] + dp[n][3]
}

//升级3：每次走的步数是在一个数组里定义，且前后不重复
func dpSteps(n int, steps []int) int {
	if n <= 1 {
		return 1
	}

	//步数数组首先要去重(必须)，然后最好排序(非必须)

	//状态定义，二维数组
	dp := make([][]int, n+1)
	length := len(steps)
	for i := range dp { //初始化二维数组，否则未将对象引用到对象的实例
		dp[i] = make([]int, length+1)
	}

	//初始值
	//初始化全部为0；在递推的时候考虑步长和累加

	//状态方程
	for i := 1; i <= n; i++ { //当前台阶
		for j := 0; j < length; j++ { //遍历步长
			last := steps[j] //从上一台阶跨last步到当前台阶
			if last > i {
				//跨last步到当前台阶，比当前台阶大，不可能
				continue
			}
			if last == i {
				//跨last步到当前台阶，刚好是第一次跨last步到此台阶，走法+1
				dp[i][j] += 1
				continue
			}
			for k := 0; k < length; k++ {
				//'上一台阶'跨last步到'当前台阶'，'上上一台阶'跨pre步到'上一台阶'，不允许重复
				pre := steps[k]
				if last == pre {
					continue
				}
				dp[i][j] += dp[i-last][k]
			}
		}
	}

	//最终值
	res := 0
	for step := range steps {
		res += dp[n][step]
	}
	return res
}

//升级3：每次走的步数是在一个数组里定义，且前后不重复
//美化版
func dpSteps2(n int, steps []int) int {
	if n <= 1 {
		return 1
	}

	//步数数组首先要去重(必须)，然后最好排序(非必须)

	//状态定义，二维数组
	dp := make([][]int, n+1)
	length := len(steps)
	for i := range dp { //初始化二维数组，否则未将对象引用到对象的实例
		dp[i] = make([]int, length+1)
	}

	res := 0

	//初始值
	//初始化全部为0；在递推的时候考虑步长和累加

	//状态方程
	for i := 1; i <= n; i++ { //当前台阶
		for j := 0; j < length; j++ { //遍历步长
			last := steps[j] //从上一台阶跨last步到当前台阶
			if last >= i {
				if last == i {
					//刚好是第一次跨last步到此台阶，走法+1，就这一种情况，直接返回
					dp[i][j] += 1
				}
				//比当前台阶大，不可能，直接返回
				continue
			}

			for k := 0; k < length; k++ {
				//'上一台阶'跨last步到'当前台阶'，'上上一台阶'跨pre步到'上一台阶'，不允许重复
				pre := steps[k]
				if last == pre {
					continue
				}
				dp[i][j] += dp[i-last][k]
			}

			if i == n {
				res += dp[i][j]
			}
		}
	}

	return res
}

//升级4：每次可以走1，2，3，..., m步，m<=n
//纯记忆：前m阶初始值是2^(m-1)种，后面m+1是dp[i] = dp[i-1]*2 - dp[i-m-1]
func dpStepM(n, m int) int {
	if n <= 1 {
		return 1
	}

	dp := make([]int, n+1)
	dp[0], dp[1] = 1, 1
	for i := 2; i <= m; i++ {
		dp[i] = 2 * dp[i-1]
	}
	for i := m + 1; i <= n; i++ {
		dp[i] = 2*dp[i-1] - dp[i-m-1]
	}
	return dp[n]
}

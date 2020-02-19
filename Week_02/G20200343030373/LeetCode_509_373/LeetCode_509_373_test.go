//https://leetcode-cn.com/problems/fibonacci-number/
//https://leetcode-cn.com/problems/powx-n/
//https://leetcode-cn.com/problems/sqrtx/
package fibonacci_test

import (
	"github.com/stretchr/testify/assert"
	"math"
	"testing"
)

func TestFib(t *testing.T) {
	//Fibonacci
	//0,1,1,2,3,5,8,13
	assert.Equal(t, 13, fib(7))
	assert.Equal(t, 13, recursionFib(7))
	assert.Equal(t, 13, memorizeFib(7))
	assert.Equal(t, 13, dpFib(7))
	assert.Equal(t, 13, dpSpaceFib(7))
	assert.Equal(t, 13, formulaFib(7))
	assert.Equal(t, 13, tableFib(7))
	assert.Equal(t, 13, matrixFib(7))
	assert.Equal(t, 13, tailRecursionFib(7, 0, 1, 2))

	//公式法举例
	//1+2+3+4=10
	n := 4
	sum1 := 0
	for i := 1; i <= n; i++ {
		sum1 += i
	}
	sum2 := n * (n + 1) / 2
	assert.Equal(t, 10, sum1) //O(n)
	assert.Equal(t, 10, sum2) //O(1)

	//power(x,n)
	//sqrt(x)
}

func fib(N int) int {
	return matrixFib(N)
}

//method1: recursion
//Go中无三目运算符
//TC: O(2^n), SC:O(n) - 递归调用栈的空间
//AC, 12ms
func recursionFib(n int) int {
	//terminator
	if n <= 1 {
		return n
	}
	//process
	//drill down
	return recursionFib(n-1) + recursionFib(n-2)
	//clear
}

//method2: speedup2-1 - space to time - memorize or cache
//if n >= 2, 算过一次就存储起来，递归下次使用时直接取（缓存的概念，O(1)）
//TC: O(n), SC: O(n)
//AC, 0ms
var hash = make(map[int]int)

func memorizeFib(n int) int {
	if n <= 1 {
		return n
	}
	if _, ok := hash[n]; !ok {
		hash[n] = memorizeFib(n-1) + memorizeFib(n-2)
	}
	return hash[n]
}

//method3: dp = recursion + memorize = transition
//recursion: 下沉后，反向返回结果
//transition: 正向递推
//TC: O(n), SC: O(n)
func dpFib(n int) int {
	//状态定义: dp[i], 累加到当前位置的结果值
	//初始值: dp[0], dp[1]
	//最终值: dp[n]
	//状态方程: dp[i]=dp[i-1]+dp[i-2]
	if n <= 1 {
		return n
	}
	dp := make([]int, n+1) //因为要使用n，所以长度是n+1
	dp[0], dp[1] = 0, 1
	for i := 2; i <= n; i++ {
		dp[i] = dp[i-1] + dp[i-2]
	}
	return dp[n]
}

//method4: dp - space decrease
//dp[]存储了每个步骤的值，但最终结果只需要比它小前两个的结果，所以可以通过变量滚动
//TC: O(n), SC: O(1)
func dpSpaceFib(n int) int {
	//prePre, pre
	//0, 1
	//pre
	//prePre, pre = pre, prePre+pre
	if n <= 1 {
		return n
	}
	prePre, pre := 0, 1
	for i := 2; i <= n; i++ {
		pre, prePre = prePre+pre, pre
	}
	return pre
}

//method5: 通项公式法
//f(n) = a1(b1)^n + a2(b2)^n
//b1 = (1 + √5)/2 (goldenRatio)
//b2 = (1 - √5)/2
//a1 = 1/√5
//a2 = -1/√5
//b2^n , b2是小于1的数，幂次会在最后四舍五入时省略
//最终结果：f(n) = (goldenRation^n)/√5
//TC: O(logn), SC: O(logn) - math.Pow的实现
func formulaFib(n int) int {
	goldenRatio := (1 + math.Sqrt(5)) / 2
	fn := math.Pow(goldenRatio, float64(n)) / math.Sqrt(5)
	return int(math.Round(fn))
}

//method6: 矩阵求幂
//线代公式：
//x y = a b * e f
//z w   c d   g h
//则
//x = ae + bg
//y = af + bh
//z = ce + dg
//w = cf + dh
//代入fib:
//f(n)   0 =  f(n-1) 0 * 1 1 = f(1) * 1 1 ^n-1
//f(n-1) 0    f(n-2) 0   1 0   f(0)   1 0
//最终方案：求power(A,N)
//最终结果：可见f(n)在最终的A[0,0]上
//TC: O(logn) SC: O(logn) - x^n递归时使用栈空间
//speedup2-2: 升维
func matrixFib(n int) int {
	if n <= 1 {
		return n
	}
	A := [2][2]int{
		{1, 1},
		{1, 0},
	}
	A = matrixPower(A, n-1)
	return A[0][0]
}

//x^n
//method1: recursion + divide&conquer
//power(a,n), a是正数，n是自然数，只需要考虑n的奇偶性
//递归+分治，O(logn)
func matrixPower(A [2][2]int, n int) [2][2]int {
	//terminator
	if n <= 1 {
		return A
	}
	//process
	//drill down
	R := matrixPower(A, n/2)
	//clear
	if n&1 == 1 {
		return multiply(A, multiply(R, R))
	}
	return multiply(R, R)
}

//线代公式
func multiply(A [2][2]int, B [2][2]int) [2][2]int {
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

//method7: table
//leetcode: 0 <= n <= 30
//TC: O(1) :)
var fibs = [31]int{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040}

func tableFib(n int) int {
	return fibs[n]
}

//method8: tail recursion
//对递归的优化手段一般是尾递归
//尾递归是指，在函数返回的时候，调用自身本身，并且return语句不能包含表达式
//这样，编译器就可以对尾递归做优化，使递归无论调用多少次，都只占用一个栈帧，栈不会增长，不会出现栈溢出
//recursionFib(4), 6次调用
//tailRecursionFib(4), 2次调用
func tailRecursionFib(n int, b1, b2 int, c int) int {
	if n <= 1 {
		return n
	}
	if n == c {
		return b1 + b2
	}
	return tailRecursionFib(n, b2, b1+b2, c+1)
}

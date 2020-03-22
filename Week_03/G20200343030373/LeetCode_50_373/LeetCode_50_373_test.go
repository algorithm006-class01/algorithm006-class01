//https://leetcode-cn.com/problems/powx-n/
package power_test

import (
	"fmt"
	"github.com/stretchr/testify/assert"
	"strconv"
	"testing"
)

func TestPower(t *testing.T) {
	t.Log("Power(x,n)")
	//power(x,n)
	x1 := 2.00000
	n1 := 10
	expect1 := 1024.00000
	ret1, _ := strconv.ParseFloat(fmt.Sprintf("%.5f", powRD(x1, n1)), 64)
	ret1b, _ := strconv.ParseFloat(fmt.Sprintf("%.5f", powBit(x1, n1)), 64)
	x2 := 2.10000
	n2 := 3
	expect2 := 9.26100
	ret2, _ := strconv.ParseFloat(fmt.Sprintf("%.5f", powRD(x2, n2)), 64)
	ret2b, _ := strconv.ParseFloat(fmt.Sprintf("%.5f", powBit(x2, n2)), 64)
	x3 := 2.00000
	n3 := -2
	expect3 := 0.25000
	ret3, _ := strconv.ParseFloat(fmt.Sprintf("%.5f", powRD(x3, n3)), 64)
	ret3b, _ := strconv.ParseFloat(fmt.Sprintf("%.5f", powBit(x3, n3)), 64)
	assert.Equal(t, expect1, ret1)
	assert.Equal(t, expect2, ret2)
	assert.Equal(t, expect3, ret3)
	assert.Equal(t, expect1, ret1b)
	assert.Equal(t, expect2, ret2b)
	assert.Equal(t, expect3, ret3b)
}

//method1: recursion + divide&conquer
//O(logn)
func powRD(x float64, n int) float64 {
	//terminator
	if n == 0 {
		return 1
	}
	//process
	//drill down
	//如果n小于0
	//都是return，不需要else
	if n < 0 {
		//x^-n = 1/(x^n)
		//一旦遇到除数，就要考虑非零
		if x == 0 {
			return 0
		}
		return powRD(1/x, -n)
	}
	//如果n大于0，n要区分奇偶
	r := powRD(x, n/2) //无论奇偶，n/2都是一样的值，所以不用n-1/2
	//clear
	//if n % 2 == 1
	if n&1 == 1 {
		//如果是奇数
		return x * r * r
	}
	return r * r
}

//method2: x^(a+b) = x^a * x^b
//n可以拆解为二进制累加，如10=8*1+4*0+2*1+1*0
//x^10 = x^8 * x^2, 即n的二进制为1的，乘进去
//每次乘进去的，就是前一个的x*x
//TCL O(logn) - n的二进制表示最多为logn
func powBit(x float64, n int) float64 {
	if n < 0 {
		if x == 0 {
			return 0
		}
		//不使用递归，直接处理
		x, n = 1/x, -n
	}

	res := 1.0
	//n一直右移，最终会变成0
	//每次移动后，x就自乘
	//如果当前位为1，则将x乘入结果内
	for ; n != 0; n >>= 1 {
		if n&1 == 1 {
			res *= x
		}
		x *= x
	}
	return res
}

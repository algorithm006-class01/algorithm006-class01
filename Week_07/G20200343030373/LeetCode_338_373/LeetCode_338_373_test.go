//https://leetcode-cn.com/problems/counting-bits/
package bitwise_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestBitwise(t *testing.T) {
	assert.Equal(t, []int{0, 1, 1}, countBits(2))
	assert.Equal(t, []int{0, 1, 1, 2, 1, 2}, countBits(5))
}

func countBits(num int) []int {
	bits := make([]int, num+1)
	for i := 1; i <= num; i++ {
		bits[i] = bits[i&(i-1)] + 1
	}
	return bits
}

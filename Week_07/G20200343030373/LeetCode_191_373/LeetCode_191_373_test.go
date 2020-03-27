//https://leetcode-cn.com/problems/number-of-1-bits/

package bitwise_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestBitwise(t *testing.T) {
	assert.Equal(t, 1, hammingWeight(8))
	assert.Equal(t, 1, hammingWeightBad(8))
	assert.Equal(t, 1, hammingWeightGood(8))
}

func hammingWeight(num uint32) int {
	return hammingWeightGood(num)
}

//对于8而言，仅循环1次
func hammingWeightGood(num uint32) int {
	count := 0
	for num != 0 {
		num = num & (num - 1)
		count++
	}
	return count
}

//对于8而言，循环4次
func hammingWeightBad(num uint32) int {
	count := 0
	for num != 0 {
		if num&1 == 1 {
			count++
		}
		num >>= 1
	}
	return count
}

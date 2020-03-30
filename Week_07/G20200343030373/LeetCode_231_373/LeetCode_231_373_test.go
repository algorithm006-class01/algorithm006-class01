//https://leetcode-cn.com/problems/power-of-two/

package bitwise_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestBitwise(t *testing.T) {
	assert.Equal(t, true, isPowerOfTwo(16))
	assert.Equal(t, false, isPowerOfTwo(9))
}

func isPowerOfTwo(n int) bool {
	return n != 0 && n&(n-1) == 0
}

//https://leetcode-cn.com/problems/generate-parentheses/
package generate_parentheses_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestGenerateParentheses(t *testing.T) {
	t.Log("Generate Parentheses")

	expect := []string{
		"((()))",
		"(()())",
		"(())()",
		"()(())",
		"()()()",
	}
	assert.Equal(t, expect, generateParenthesis(3))
}

//字符串长度为2n，每个元素有两种选择，则O(2^(2n))，再判断合法
//改进，DFS+Prune
//记录左右括号各使用多少个，最多n
//保证左括号比右括号先用
//O(2^n)
func generateParenthesis(n int) []string {
	if n <= 0 {
		return []string{}
	}
	var result []string
	generateOneByOne(&result, "", n, n)
	return result
}

func generateOneByOne(result *[]string, sublist string, left, right int) {
	if left == 0 && right == 0 {
		*result = append(*result, sublist)
		return
	}

	if left > 0 { //left和right的个数为n
		generateOneByOne(result, sublist+"(", left-1, right)
	}
	if right > left { //剩余右括号比左括号多：左括号先用，右括号后用 - 则无需在判断right>0
		generateOneByOne(result, sublist+")", left, right-1)
	}
}

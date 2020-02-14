//https://leetcode-cn.com/problems/valid-parentheses/description/
package valid_parentheses_test

import (
	_ "fmt"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestValidParentheses(t *testing.T) {
	str1 := "()"
	str2 := "()[]{}"
	str3 := "(]"
	str4 := "([)]"
	str5 := "{[]}"

	assert.Equal(t, true, isValid(str1))
	assert.Equal(t, true, isValid(str2))
	assert.Equal(t, false, isValid(str3))
	assert.Equal(t, false, isValid(str4))
	assert.Equal(t, true, isValid(str5))
}

//Define a Stack: Push, Pop, IsEmpty
type Stack struct {
	strSlice []string
}

func (stack *Stack) Push(str string) {
	stack.strSlice = append(stack.strSlice, str)
}

func (stack *Stack) Pop() string {
	lenSlice := len(stack.strSlice)
	if lenSlice == 0 {
		return ""
	}

	str := stack.strSlice[lenSlice-1]
	stack.strSlice = stack.strSlice[:lenSlice-1] //截取的边界是[), 左包含右不包含

	return str
}

func (stack *Stack) IsEmpty() bool {
	return len(stack.strSlice) == 0
}

var hash = map[string]string{
	")": "(",
	"]": "[",
	"}": "{",
}

//Judge with a Stack
func isValid(s string) bool {
	stack := new(Stack)

	for _, b := range s { //range出的是key,value；如果只有一个值，则是key or index
		str := string(b)                //range string 出的是rune，int32类型，需要类型转换
		if left, ok := hash[str]; !ok { //map的是value, ok, 即对应key的value
			//判断map的key是否存在，如果不存在，即为左字符，则入栈
			stack.Push(str)
		} else if stack.IsEmpty() || stack.Pop() != left { //如果存在，则为右字符，先判断是否为空，再出栈判断是否匹配
			return false
		}
	}

	//如果为空(配对全部出栈、无其他字符)，则有效
	return stack.IsEmpty()
}

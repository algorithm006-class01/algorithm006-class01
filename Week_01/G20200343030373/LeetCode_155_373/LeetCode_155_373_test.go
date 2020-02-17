//https://leetcode-cn.com/problems/min-stack/
package mini_stack_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestMiniStack(t *testing.T) {
	t.Log("Mini Stack")
	obj := Constructor()
	obj.Push(-2)
	obj.Push(0)
	obj.Push(-3)
	assert.Equal(t, -3, obj.GetMin())
	obj.Pop()
	assert.Equal(t, 0, obj.Top())
	assert.Equal(t, -2, obj.GetMin())
}

//当辅助栈为空的时候直接放入新数据
//push的时候如果该元素小于等于辅助栈顶元素，则将其推入辅助栈
//出栈的时候如果出栈元素等于辅助栈栈顶元素辅助栈也跟着出栈
//O(1), O(n)
type MinStack struct {
	data []int
	help []int
}

/** initialize your data structure here. */
func Constructor() MinStack {
	return MinStack{
		data: []int{},
		help: []int{},
	}
}

//辅助栈的栈顶元素永远是最小值
func (this *MinStack) GetMin() int {
	return this.help[len(this.help)-1]
}

func (this *MinStack) Push(x int) {
	//如果辅助栈之前为空，则直接放入
	//如果新值小于等于最小值，则将新值加入辅助栈，作为辅助栈栈顶
	if len(this.help) == 0 || x <= this.GetMin() {
		this.help = append(this.help, x)
	}
	this.data = append(this.data, x)
}

func (this *MinStack) Pop() {
	x := this.data[len(this.data)-1]
	this.data = this.data[:len(this.data)-1]
	//出栈时，如果值刚好等于最小值，辅助栈也跟随出栈
	if x == this.GetMin() {
		this.help = this.help[:len(this.help)-1]
	}
}

func (this *MinStack) Top() int {
	return this.data[len(this.data)-1]
}

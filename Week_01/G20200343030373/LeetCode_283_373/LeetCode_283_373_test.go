//https://leetcode-cn.com/problems/move-zeroes/
package move_zeroes_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestMoveZeroes(t *testing.T) {
	nums := []int{0, 1, 0, 3, 12}
	expect := []int{1, 3, 12, 0, 0}
	moveZeroes(nums)
	assert.Equal(t, expect, nums)

	nums = []int{0, 1, 0, 3, 12}
	countNoneZero(nums)
	assert.Equal(t, expect, nums)

	nums = []int{0, 1, 0, 3, 12}
	dualPointerChange(nums)
	assert.Equal(t, expect, nums)

	nums = []int{0, 1, 0, 3, 12}
	dualPointerSwap(nums)
	assert.Equal(t, expect, nums)

	nums1 := []int{1}
	moveZeroes(nums1)
	assert.Equal(t, nums1, nums1)
}

func moveZeroes(nums []int) {
	//Best
	//其实dualPointerChange就是countNoneZero考虑在一次遍历里解决问题；
	//dualPointerSwap就是dualPointerChange的更直接、简洁版本
	dualPointerSwap(nums)
}

//method1: 两层循环
//第一层循环将非零元素放到数组前面
//第二层循环后面补零
//worst: O(2n)
func countNoneZero(nums []int) {
	fast, slow := 0, 0
	for ; fast < len(nums); fast++ {
		if nums[fast] != 0 { //对于每一个快指针元素值不为0，要做两步操作，先将非零元素替换，再移动慢指针
			if fast != slow { //优化，不加这句判断也对，加这句减少一次交换
				nums[slow] = nums[fast]
			}
			slow++ //注意，每一次不为零都需要移动slow，否则[]int{1}错误
		}
	}
	for ; slow < len(nums); slow++ {
		nums[slow] = 0
	}
}

//method2: 双指针
//快指针遇到 非零 就和慢指针的数字做交换，慢指针做过一次交换后就累加，保持顺序
//O(n)
func dualPointerChange(nums []int) {
	fast, slow := 0, 0
	for ; fast < len(nums); fast++ {
		if nums[fast] != 0 {
			if fast != slow { //如果fast等于slow，则在原地，将slow后移保留即可
				nums[slow] = nums[fast] //如果fast不等于slow，fast在slow的后面；fast的值又是非零，则与slow的值交换，fast的值改成零，slow后移
				nums[fast] = 0
			}
			slow++
		}
	}
}

func dualPointerSwap(nums []int) {
	fast, slow := 0, 0
	for ; fast < len(nums); fast++ {
		if nums[fast] != 0 {
			if fast != slow {
				nums[slow], nums[fast] = nums[fast], nums[slow] //slow把每一个非零值都做了交换，则剩下的fast自然而然就都是零
			}
			slow++
		}
	}
}

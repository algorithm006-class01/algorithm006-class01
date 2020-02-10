//https://leetcode-cn.com/problems/two-sum/
package two_sum_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestTwoSum(t *testing.T) {
	t.Log("Two Sum")

	target := 9
	nums := []int{2, 7, 11, 15}
	expect := []int{0, 1}
	assert.Equal(t, expect, twoSum(nums, target))

	target1 := 6
	nums1 := []int{3, 3}
	expect1 := []int{0, 1}
	assert.Equal(t, expect1, twoSum(nums1, target1))
}

func twoSum(nums []int, target int) []int {
	myMap := make(map[int]int)
	for index, value := range nums {
		//TwoSum: 将'target-当前值'作为key存入Map，当前值的索引作为value存入Map；
		//遍历后面的元素，如果'后面的元素值'作为Map的key已经存在，则找到，返回索引
		//Special: '后面的元素值'存在于Map的既有索引值，例如3+3=6，不应该覆盖
		if vIndexOld, ok := myMap[value]; !ok {
			myMap[target-value] = index
		} else {
			return []int{vIndexOld, index}
		}
	}
	return nil
}

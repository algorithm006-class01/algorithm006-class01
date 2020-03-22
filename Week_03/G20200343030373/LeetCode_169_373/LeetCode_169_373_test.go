//https://leetcode-cn.com/problems/majority-element/
package majority_element_test

import (
	"github.com/stretchr/testify/assert"
	"sort"
	"testing"
)

func TestMajorityElement(t *testing.T) {
	t.Log("Divide&Conquer - Majority Element")

	nums1 := []int{3, 2, 3}
	assert.Equal(t, 3, majorityElement(nums1))
	assert.Equal(t, 3, majorityElementMap1(nums1))
	assert.Equal(t, 3, majorityElementMap2(nums1))
	assert.Equal(t, 3, majorityElementSort(nums1))
	assert.Equal(t, 3, majorityElementDC(nums1))
	assert.Equal(t, 3, majorityElementVote(nums1))

	nums2 := []int{2, 2, 1, 1, 1, 2, 2}
	assert.Equal(t, 2, majorityElement(nums2))
	assert.Equal(t, 2, majorityElementMap1(nums2))
	assert.Equal(t, 2, majorityElementMap2(nums2))
	assert.Equal(t, 2, majorityElementSort(nums2))
	assert.Equal(t, 2, majorityElementDC(nums2))
	assert.Equal(t, 2, majorityElementVote(nums2))
}

func majorityElement(nums []int) int {
	return majorityElementVote(nums)
}

//method1.1: map, key: 元素，value: 数量
//遍历map，找到数量的最大值
//O(n), O(n)
func majorityElementMap1(nums []int) int {
	//将元素的数量存入map
	hash := make(map[int]int)
	for _, v := range nums {
		hash[v]++
	}

	majorityE, maxCount := 0, 0
	//遍历、覆盖找到最大值，题目有前提
	for element, count := range hash {
		if count > maxCount {
			majorityE, maxCount = element, count
		}
	}
	return majorityE
}

//method1.2: map, key: 元素， value：数量
//较上一方法，只需要遍历一次，无需再次遍历hash，边遍历边比较 - 压缩空间
//O(n), O(n)
func majorityElementMap2(nums []int) int {
	//初始值是第一个元素，初始数量为0
	majorityE := nums[0]
	hash := map[int]int{
		majorityE: 0,
	}
	//边遍历边比较、覆盖
	for _, element := range nums {
		hash[element]++ //每次遍历就计数，反映真实数量
		if hash[element] > hash[majorityE] {
			majorityE = element
		}
	}
	return majorityE
}

//method2: 题目有前提，肯定存在众数，且众数的个数大于len/2
//则排序后，第len/2个肯定为众数
//快排 O(nlogn), O(1)
func majorityElementSort(nums []int) int {
	sort.Ints(nums)
	return nums[len(nums)/2]
}

//method3: 分治
//题目有前提，肯定存在众数，且众数的个数大于len/2
//左边找众数，右边也找
//如果找到的众数元素值相等，则返回
//如果不相等，则返回计数多的那一边
//O(nlogn), O(logn)
func majorityElementDC(nums []int) int {
	//包含左边和右边的索引
	return majority(nums, 0, len(nums)-1)
}

func majority(nums []int, leftIndex int, rightIndex int) int {
	//终止条件，遍历结束，直接返回当前值
	if leftIndex == rightIndex {
		return nums[leftIndex]
	}

	//无需区分奇偶，奇偶/2得到相同的值，总能包含完全
	midIndex := (leftIndex + rightIndex) / 2
	leftMax := majority(nums, leftIndex, midIndex)
	rightMax := majority(nums, midIndex+1, rightIndex)

	//回归判断1：如果左右两边众数相等，则直接返回
	if leftMax == rightMax {
		return leftMax
	}
	//回归判断2：如果不相等，则找左右两边分别的众数 出现的次数 多的那个众数
	leftCount, rightCount := 0, 0
	for i := leftIndex; i < midIndex; i++ {
		if leftMax == nums[i] {
			leftCount++
		}
	}
	for i := midIndex; i < rightIndex; i++ {
		if rightMax == nums[i] {
			rightCount++
		}
	}
	if leftCount > rightCount {
		return leftMax
	}
	return rightMax
}

//method4: 摩尔投票法只关注次数
//众数比其他数多：众数的次数+1，其他的-1，则将次数全部加起来，和大于0
//如果初始值就为众数、计数为1，则count一直累加，直接返回众数
//如果初始值不为众数、计数为1，后续众数的出现会将计数累减为0。此时将众数赋值给计数的数值，后续的数字就没机会覆盖众数计数值了
func majorityElementVote(nums []int) int {
	cur, count := 0, 0
	for _, v := range nums {
		if count == 0 {
			cur = v
		}

		if cur == v {
			count++
		} else {
			count--
		}
	}
	return cur
}

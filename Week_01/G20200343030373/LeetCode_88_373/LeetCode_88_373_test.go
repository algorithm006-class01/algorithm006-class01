package merge_two_sorted_array_test

import (
	"github.com/stretchr/testify/assert"
	"sort"
	"testing"
)

func TestMergeArray(t *testing.T) {
	nums1 := []int{1, 2, 3, 0, 0, 0}
	nums2 := []int{2, 5, 6}
	m, n := 3, 3
	expect := []int{1, 2, 2, 3, 5, 6}
	merge(nums1, m, nums2, n)
	assert.Equal(t, expect, nums1)
}

func merge(nums1 []int, m int, nums2 []int, n int) {
	arrayMerge(nums1, m, nums2, n)
}

//双指针法
//处理数组，而不是处理切片
//从后往前遍历，可以原地进行处理，直接将最后面的数放到nums1后面，已放好的数组无需再次移动
func arrayMerge(nums1 []int, m int, nums2 []int, n int) {
	//直接返回，nums1
	if n == 0 {
		return
	}
	//直接将n个元素添加到nums1
	if m == 0 {
		for i := 0; i < n; i++ {
			nums1[i] = nums2[i]
		}
		return
	}

	for m > 0 && n > 0 {
		//从后往前，进行比较
		if nums1[m-1] < nums2[n-1] {
			nums1[m+n-1] = nums2[n-1] //nums1数字比nums2小，则将nums2数字放到较后面
			n--
		} else {
			nums1[m+n-1] = nums1[m-1]
			m--
		}
		//m总比n大
		if m == 0 && n > 0 {
			for n > 0 {
				nums1[m+n-1] = nums2[n-1]
				n--
			}
		}
	}
}

//切片排序
//go语言特性
func sliceMerge(nums1 []int, m int, nums2 []int, n int) {
	nums1 = append(nums1[:m], nums2[:n]...)
	sort.Ints(nums1)
}

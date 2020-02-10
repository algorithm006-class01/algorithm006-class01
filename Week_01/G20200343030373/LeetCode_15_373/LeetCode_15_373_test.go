//https://leetcode-cn.com/problems/3sum/
package three_sum_test

import (
	"github.com/stretchr/testify/assert"
	"sort"
	"testing"
)

func TestThreeSum(t *testing.T) {
	t.Log("Three Sum")

	nums1 := []int{-1, 0, 1, 2, -1, -4}
	except1 := [][]int{
		{-1, -1, 2},
		{-1, 0, 1},
	}
	assert.Equal(t, except1, threeSum(nums1))

	nums2 := []int{0, 0, 0, 0}
	except2 := [][]int{{0, 0, 0}}
	assert.Equal(t, except2, threeSum(nums2))

	nums3 := []int{-2, 0, 1, 1, 2}
	except3 := [][]int{
		{-2, 0, 2},
		{-2, 1, 1},
	}
	assert.Equal(t, except3, threeSum(nums3))
}

func threeSum(nums []int) [][]int {
	var ret [][]int
	if len(nums) < 3 {
		return ret
	}

	sort.Ints(nums) //需要排序，容易忘记

	//注意i的取值，肯定会留出两个值给l和r
	for i := 0; i <= len(nums)-3; i++ {
		l, r := i+1, len(nums)-1

		//i并不是跟后面的去重，而是跟前面的去重，已经处理过相同的i
		//-1, -1, 0, 1
		if i-1 >= 0 && nums[i] == nums[i-1] { //与后面r+1<=len(nums)-1相同的意思，都是要在数组边界内
			continue
		}

		if nums[i] > 0 || nums[i]+nums[l] > 0 {
			break
		}

		//移动l,r去重，肯定会剩下至少三个元素分别是i,l,r去求和，所以退出条件是l<r
		for l < r {
			//l与r去重，也是跟已经处理过的去重
			//-1，0，0，1，1
			if l-1 > i && nums[l] == nums[l-1] { //l必须大于i
				l++
				continue //每移动一次，就要去判断l与r
			}
			if r+1 <= len(nums)-1 && nums[r] == nums[r+1] { //在数组边界内
				r--
				continue
			}

			if nums[i]+nums[l]+nums[r] > 0 {
				r--
			} else if nums[i]+nums[l]+nums[r] < 0 {
				l++
			} else {
				ret = append(ret, []int{nums[i], nums[l], nums[r]})
				r--
				l++
			}
		}
	}

	return ret
}

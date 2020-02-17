//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

package main

func removeDuplicates(nums []int) int {
	length := len(nums)
	if length == 0 {
		return 0
	}
	p := 1
	for i := 1; i < length; i++ {
		if nums[i] != nums[p-1] {
			nums[p] = nums[i]
			p++
		}
	}
	return p
}

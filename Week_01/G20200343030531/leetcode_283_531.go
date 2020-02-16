package main

import (
"fmt"
)

func main()  {
	sli := []int{0, 1, 0 , 3, 12, 0, 0, 14, 4}
	moveZeroes(sli)
}

// 双指针法
// 双指针法，快指针向前移动，慢指针指向当前0值，快指针位置是非零值，
// 则将该值移动到慢指针位置，慢指针前进一位，
// 补零操作，

// 记录0值操作非常多余，把非零值移动到前面，插入下标以后的都是0值
func moveZeroes(nums []int)  {
	var count int
	slow := 0
	for quick := 0; quick < len(nums); quick++ {
		if nums[quick] == 0 {
			count++
		}else {
			nums[slow] = nums[quick]
			slow++
		}
	}
	for i := (len(nums) - count); i < len(nums); i++  {
		nums[i] = 0
	}
	fmt.Println(nums)
}

// 该方法通过记录0值个数，将非零值前移，然后末端补零的方式实现移动
/*
func moveZeroes(nums []int)  {

	var count int
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			count++
		}else {
			nums[i-count] = nums[i]
		}
	}

	for i := (len(nums) - count); i < len(nums); i++ {
		nums[i] = 0
	}
	fmt.Println(nums)
}
*/
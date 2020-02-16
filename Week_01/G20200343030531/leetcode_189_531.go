package main

import "fmt"

func main()  {
	a := []int{1, 2, 3, 4, 5, 6 ,7}
	rotate(a, 5)
}
// 暴力法
// 太复杂了，失败，需要思考为什么这样做
/*
	反思：1.可以从第一个开始就进行置换处理，获取最后一个进行置换
		 2.到了最后一个的时候实际上已经完成所有的置换了。
   		 3.这里有个问题就是从第一个开始直接置换之前的还是等带置换最后的。
*/
/*
func rotate(nums []int, k int)  {
	for i := 0; i < k; i++ {
		var temp, previous int
		for j := 0; j < len(nums); j++ {
			if j+1 < len(nums) {
				if j == 0 {
					previous = nums[0]
				}else {
					previous = temp
				}
				temp = nums[j+1]
				nums[j+1] = previous
			}else {
				nums[0] = temp
			}

		}
	}
}
*/
// 经典暴力法
/*
func rotate(nums []int, k int) {
	for i := 0; i < k; i++ {
		var temp, previous int
		previous = nums[len(nums) - 1]
		for j := 0; j < len(nums); j++ {
			temp = nums[j]
			nums[j] = previous
			previous = temp
		}
	}
	fmt.Println(nums)
}
*/
// 使用反转
func rotate(nums []int, k int) {
	k %= len(nums)
	revers(&nums, 0, len(nums)-1)
	fmt.Println(nums)
	revers(&nums, 0, k-1)
	fmt.Println(nums)
	revers(&nums, k, len(nums)-1)
	fmt.Println(nums)

	/*
	// 全部反转
	rotateAll(&nums)
	fmt.Println("第二次打印：", nums)
	// 前部反转
	rotateFront(&nums, 0, k)
	fmt.Println("第四次打印：", nums)
	// 后部反转
	rotateBack(&nums, k, len(nums))
	fmt.Println("第六次打印：", nums)
	*/
}
// 全部反转
// 使用双指针夹逼替换
/*
func rotateAll(nums *[]int)  {
	for i := 0; i < len(*nums)/2; i++ {
		var temp int
		temp = (*nums)[i]
		(*nums)[i] = (*nums)[len(*nums)-1-i]
		(*nums)[len(*nums)-1-i] = temp
	}
	fmt.Println("第一次打印：", *nums)
}

// 前部反转
func rotateFront(nums *[]int, start, end int)  {
	for i := 0; i < end/2; i++ {
		var temp int
		temp = (*nums)[i+start]
		(*nums)[i+start] = (*nums)[end-i-1]
		(*nums)[end-i-1] = temp
	}
	fmt.Println("第三次打印：", *nums)
}

// 后部反转
func rotateBack(nums *[]int, start, end int)  {
	for i := 0; i < (end-start)/2; i++ {
		fmt.Println("i = ", i, "start = ", start, "end = ", end)
		var temp int
		temp = (*nums)[i+start]
		(*nums)[i+start] = (*nums)[end-i-1]
		(*nums)[end-i-1] = temp
	}
	fmt.Println("第五次打印：", *nums)
}
*/
// 对照leetcode使用反转解法
func revers(num *[]int, start, end int)  {
	for start < end  {
		var temp int
		temp = (*num)[start]
		(*num)[start] = (*num)[end]
		(*num)[end] = temp
		start++
		end--
	}
}

package main

import (
	"fmt"
	"sort"
)

func main() {
	g, s := []int{10, 9, 8, 7}, []int{5, 6, 7, 8}

	fmt.Println("结果 nums = ", findContentChildren(g, s))
}

// 题解反思
/*
	1.首先的考虑将这些排序一下
	2.第一次解题的时候没考虑到饼干的最后与孩子胃口之前能够匹配
	3.这类题目应该用双指针去解题
*/
func findContentChildren(g []int, s []int) int {
	// 先进行排序
	sort.Ints(g)
	sort.Ints(s)
	// 计算
	nums, si, gi := 0, 0, 0
	for gi < len(g) && si < len(s) {
		if g[gi] <= s[si] {
			nums++
			gi++
			si++
		} else {
			si++
		}
	}
	return nums
}

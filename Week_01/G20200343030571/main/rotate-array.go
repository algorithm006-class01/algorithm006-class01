package main
/*
旋转数组
	给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
	
	示例 1:
	输入: [1,2,3,4,5,6,7,8] 和 k = 3
	输出: [6,7,8,1,2,3,4,5]
	解释:
	向右旋转 1 步: [7,1,2,3,4,5,6]
	向右旋转 2 步: [6,7,1,2,3,4,5]
	向右旋转 3 步: [5,6,7,1,2,3,4]

/*
	一开始看了题之后毫无头绪，暴力法都没想出来，然后去看了题解发现原来那么暴力。。。
	感觉那种暴力法我也能想出来，就是没往那么暴力上想。然后通过暴力法也没想到啥好的优化解法。
	再看官方题解的三次反转，一开始没看懂时以为是用了啥比较高级的数学原理，后来再一看，才发现原来这个原理就是基于常识的。
	然后有了思路就自己动手写了下，
	自己一开始没想到len == 1和k == 0的情况，只想到了len == 0的情况。
	修改后通过，才击败36.92%
*/
func rotate1(nums []int, k int)  {
	len := int(len(nums))
	if len <= 1 	{return}
	k = k % len
    if k == 0   {return}
	reverse1(nums, 0, len-1)
	reverse1(nums, 0, k-1)
	reverse1(nums, k, len-1)
}

func reverse1(nums []int, i int, j int) {
	for {
			nums[i], nums[j] = nums[j], nums[i]
			i++
			j--
			if i >= j {
				break
			}
	}
}
/*
	全看了下题解，发现是因为这题应该用while-do的逻辑而不是do-while.
	用while-do的好处不仅可以省去一开始对k == 0的判断。
	并且当 k == 1|| k == len-1时，可以少在一次反转中做一个不必要的反转操作（即：我 转 我 自 己）。
	修改代码如下，击败95.48%

*/
func rotate2(nums []int, k int)  {
	len := int(len(nums))
	if len <= 1 	{return}
	k = k % len
    //if k == 0   {return}
	reverse2(nums, 0, len-1)
	reverse2(nums, 0, k-1)
	reverse2(nums, k, len-1)
}

func reverse2(nums []int, i int, j int) {
	for {	
			if i >= j {
				break
			}
			nums[i], nums[j] = nums[j], nums[i]
			i++
			j--
			
	}
}
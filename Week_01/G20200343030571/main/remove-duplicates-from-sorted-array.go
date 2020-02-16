package main
/*
删除排序数组中的重复项：

给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O (1) 额外空间的条件下完成。
*/


/*
	一开始自己能想出个大概思路，应该也算是属于“用空间换时间”范围里的。
	就是在一次遍历中，用两个指针，一个指针负责遍历，一个指针负责记录“遇到下一个非重复项的时候应该插入的地方”
	然后用一个变量temp来存储应该与遍历指针进行比对来看是否重复的数，也就是遇到的最新的非重复的数。
*/

/*
	以下是自己按照思路，并修改直到通过的代码。
	由于思路不够清晰，一开始写的代码错误百出，甚至把判断是否重复后分别的操作给搞混了。
*/
func removeDuplicates1(nums []int) int {
    if len(nums) == 0 {
        return 0
    }
    temp := nums[0]

	i,j := int(1),int(1)
	for ; i < len(nums); i++ {
		if nums[i] == temp {
		} else {
            nums[j] = nums[i]
			temp = nums[i]
            j++
		}
	}
	return j
}

/*
	通过查看别人的题解，发现自己代码中的temp变量是不必要的，因为其实那个慢指针前面位置的元素
	就等于是temp.
	然后自己写了removeDuplicates2.
	然后照着这个思路写完之后，发现自己的代码才打败30%左右，觉得不对劲。
	
	再比对，发现这是由于自己有个定势思维，就是那个慢指针一定是要指向下一个被插入的位置，然后他的
	上一个位置来替换temp.这就导致了我每次if判断中都要执行一次j-1的计算操作。
*/

func removeDuplicates2(nums []int) int {
	len := int(len(nums))
	if len == 0 {return 0} 

	i,j := int(1),int(1)
	for ; i < len; i++ {
		if (nums[i] != nums[j-1]) {
			nums[j] = nums[i]
			j++
		}
	}
	return j
}

/*
	最终版本如下：
	通过调换赋值与自增的顺序。慢指针在对比前直接指向应该比对的元素。
	比对发现不相等后，再自增正好指向了这次应该赋值的位置与下一次比对的位置。
	击败了93.93%
*/
func removeDuplicates3(nums []int) int {
	len := int(len(nums))
	if len == 0 {return 0} 

	i,j := int(1),int(0)
	for ; i < len; i++ {
		if (nums[i] != nums[j]) {
            j++
            nums[j] = nums[i]
            
		}
	}
	return j + 1
}
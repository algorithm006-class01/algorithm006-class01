package main

/*
169. 多数元素

给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于  n/2  的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

*/
/*
	自己想的思路：
	map k-v : num-count
	O(n)
	开始的时候以为要遍历两遍，即给的数组遍历一遍。存好map以后再遍历map一遍，
	但写的时候想了下，其实可以在第一次遍历的时候直接得出结果。
	每次更新次数的时候更新下count值然后和半数进行比对即可。
	一开始没有考虑到的情况是数组里只有一个元素
	此方法提交后，击败71%
*/
func majorityElement1(nums []int) int {
	mapCount  := make(map[int]int,0)
	l := len(nums)
	if l == 1 {
		return nums[0]
	}
	half := int(l / 2)
	res := int(0)
	for _, v := range nums {
		count, ok := mapCount[v]
		if !ok {
			mapCount[v] = 1
		} else {
			mapCount[v] = count + 1
			if count + 1 > half {
				res = v
			}
		}
	}
	return res
}

/*
	以下为看完题解的思路：
	分治法
	将所给的数组不断地从中间断开，得出左右分别的众数，然后通过比较结果
	如果结果一样直接返回，否则返回出现次数多的那个。
	分支法可真正用于“求众数”即，返回结果中出现次数最多的那个，而非仅仅是出现次数>=n
*/

/*
		注释##处为最关键的细节，即当左右相等的情况，一定要return 右子数组中的众数。
		原因如下：
		如果只从某一次的反还结果来看，当左右子数组中的众数出现次数一致时，无论返回哪个都是错的。
		因为无论返回哪个，都存在一种可能，即在另外的子数组中，众数等于当前被“抛弃”的数，另外其在另外的
		子数组出现的次数并不大于当前这个选中的数，但是若加上在当前数组的次数，就大于了。但是因为已经被“抛弃”，
		就错过了这个清算的机会，导致结果错误。
		举例：[6,5,X] (先姑且认为X未知)
		->[6,5],[X]
		->[6],[5]    [X]
		此时对于[6,5]的左右子数组，分别得出6,5的结果，且其在各自子数组出现次数一致，都是1.
		如果我们返回6而抛弃5,且X==5,那么我们最终很有可能会得出6这个错误的结果。因为5已经被抛弃，我们不会再一直
		记得5的次数，所以不会与右侧的次数进行累加。在下一步只是左侧的6,与右侧的5进行比较，且次数都为1.
		如果我们抛弃6而返回5同理，当X==6时，也存在相同隐患

		这么一看，可能会给人的第一印象是这道题没办法用分治法来解，因为我们选哪一侧都有隐患。
		但其实，如果我们站在更高的层次，即不看某一次的返回结果，我们会发现，其实错误的隐患可以描述为：一个错误的结果会被多次选择。
		比如对于[6,5,5],6被选择了两次
		由于我们每次选择的方向是一样的（要么都返回左边，要么都返回右边）所以其实我们可以通过返回右侧直接
		排除掉“一个错误的结果会被多次选择”这个可能。
		即对于[6,5,6],我们第一次返回5，那么第二次肯定就选不到5而是6.即便到最后我们得出6这个结果的依据，如果只看最后那一步似乎是
		不靠谱的,我们认为6与5出现的次数一样多，但其实我们站在更高的层次已经确定了正确答案一定是6
	*/
func majorityElement(nums []int) int {
	return majorityElementDivide(0, len(nums)-1, nums)
}

func majorityElementDivide(lo int, hi int, nums []int) int {
	if lo == hi {
		return nums[lo]
	}
	mid := (lo + hi) / 2
	leftRes := majorityElementDivide(lo, mid, nums)
	rightRes := majorityElementDivide(mid+1, hi, nums)
	if leftRes == rightRes {
		return leftRes
	}

	leftCount := count(leftRes, lo, mid, nums)
	rightCount := count(rightRes, mid+1, hi, nums)

	if leftCount > rightCount {	//##
		return leftRes
	}
	return rightRes
}

func count(num int, lo int, hi int, nums []int) int {
	res := int(0)
	rangeNums := nums[lo : hi+1]
	for _, v := range rangeNums {
		if v == num {
			res++
		}
	}
	return res
}

func main() {
	nums := []int {6,5,5,0,0,1,2,5}
	res := majorityElement(nums)
	println(res)
}
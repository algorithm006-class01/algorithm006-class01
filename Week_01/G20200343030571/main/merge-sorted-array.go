package main
/*
合并两个有序数组:
	给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

	说明:
	初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
	你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

	示例:
	输入:
	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3

	输出: [1,2,2,3,5,6]
*/
/*
	暴力法：用nums2从头到尾依次跟nums1比较，小于等于则插入。
	O(m*n)

	排序法：直接插到尾部然后排序
	O((n+m)log(n+m))

*/

/*
	去看了一眼题解，发现原来只要从后往前插入数据，就可以省去了暴力法多次在元素中间
	插入元素的开销，妙啊

*/
func merge(nums1 []int, m int, nums2 []int, n int)  {
	len1 := m - 1
	len2 := n - 1
	len  := m + n - 1

	for {
		if len1 < 0 || len2 < 0 {
			break
		}
		if nums2[len2] >= nums1[len1] {
			nums1[len] = nums2[len2]
			len2--
		} else {
			nums1[len] = nums1[len1]
			len1--
		}
		len--
	}
	if len2 >= 0 {
		copy(nums1[0:len2+1], nums2[0:len2+1])
	}
	
}

"""
    给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

    说明:
        初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
        你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

    示例:

        输入:
            nums1 = [1,2,3,0,0,0], m = 3
            nums2 = [2,5,6],       n = 3
        输出: [1,2,2,3,5,6]
"""

from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """

    @classmethod
    def double_pointer_v1(cls, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
            定义两个指针，分别都从0开始 循环遍历，判断对应的值，添加到新列表中。
            循环结束后，新列表需要更新nums1或者nums2剩余的元素。
            最后将新列表赋值给nums1。
            时间复杂度:O(m+n)，空间复杂度O(m+n)
        """
        i = j = 0
        res = []

        while i < m and j < n:
            if nums1[i] < nums2[j]:
                res.append(nums1[i])
                i += 1
            else:
                res.append(nums2[j])
                j += 1
        res += (nums1[i:m] + nums2[j:n])

        nums1[:] = res

    @classmethod
    def double_pointer_v2(cls, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
            双指针解法2，从后往前。
            首先计算出合并后数组的最大下标。
            从两个数组的指定位置的后面开始遍历。比较结果，然后插入到后面的位置并且对应的下标减1。循环判断
            最后需要处理一下nums2遗留的数据
            时间复杂度:O(m+n)，空间复杂度O(1)
        """
        p = m + n - 1  # 表示是新的nums1的最后一个下标地址

        p1 = m - 1
        p2 = n - 1

        while p1 >= 0 and p2 >= 0:
            if nums1[p1] > nums2[p2]:
                nums1[p] = nums1[p1]
                p1 -= 1
            else:
                nums1[p] = nums2[p2]
                p2 -= 1
            p -= 1
        nums1[0:p2 + 1] = nums2[0:p2 + 1]


if __name__ == '__main__':
    a = [1, 2, 3, 0, 0, 0]
    b = [1, 5, 6]
    Solution.double_pointer_v1(a, 3, b, 3)
    # print(a)

    a1 = [2, 4, 5, 0, 0, 0, 0, 0, 0]
    b1 = [1, 2, 3]
    Solution.double_pointer_v2(a1, 3, b1, 3)
    print(a1)

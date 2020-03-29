"""
    给你两个数组，arr1 和 arr2，
        arr2 中的元素各不相同
        arr2 中的每个元素都出现在 arr1 中
        对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

    示例：
        输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
        输出：[2,2,2,1,4,3,3,9,6,7,19]
    提示：
        arr1.length, arr2.length <= 1000
        0 <= arr1[i], arr2[i] <= 1000
        arr2 中的元素 arr2[i] 各不相同
        arr2 中的每个元素 arr2[i] 都出现在 arr1 中
"""
from typing import List


class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        # 1. 初始化三个变量 arr2_dict 用来统计arr2_中数据
        arr2_dict = dict()  # 用来存储arr2在出现在arr1中数据的个数
        arr1_list = list()
        diff_list = []  # 用来表示存在1中但是不在2中的数据

        for num in arr2:
            arr2_dict[num] = 0

        for num in arr1:
            if num in arr2_dict:
                arr2_dict[num] += 1
            else:
                diff_list.append(num)

        diff_list.sort()

        for num in arr2:
            arr1_list.extend([num] * arr2_dict[num])
        arr1_list.extend(diff_list)
        return arr1_list

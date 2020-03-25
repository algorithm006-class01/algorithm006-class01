/**
 * @param {number[]} nums
 * @return {number}
 */
// 归并排序的合并过程中，获取逆序元素个数
var reversePairs = function (nums) {
    if (!nums || nums.length === 0) return 0
    return mergeSort(nums, 0, nums.length - 1)
};

function mergeSort(nums, left, right) {
    if (left >= right) return 0
    const mid = parseInt(left + (right - left) / 2)
    return mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right) + merge(nums, left, mid, right)
}

function merge(nums, left, mid, right) {
    let i = left, l = left, count = 0, tmp = [], p = 0;
    for (let j = mid + 1; j <= right; j++) {
        while (i <= mid && nums[i] / 2 <= nums[j]) i++
        count += mid - i + 1 // 左边的元素比右边元素的第j个比，有mid-i+1个是大于两倍的

        while (l <= mid && nums[l] < nums[j]) tmp[p++] = nums[l++]
        tmp[p++] = nums[j]
    }
    while (l <= mid) tmp[p++] = nums[l++]
    for (let p = 0; p < tmp.length; p++) {
        nums[left + p] = tmp[p]
    }
    return count
}
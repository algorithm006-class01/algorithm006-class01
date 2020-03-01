/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
// 二分查找
// 元素经过旋转后，不再是全局单调递增，但旋转点的左右部分还是递增的，且递增方向一致；
// [nums[left], mid]
//   如果 nums[left] < mid，表示这部分递增，target < nums[left] 或 target > mid，命中后半部分；
//   如果 nums[left] > mid，表示这部分不是递增，target < nums[left] 且 target > mid，命中后半部分；
// 否则，命中前半部分；
// 每次需要判断mid是否等于target，是则返回其索引，否则返回-1
// 遍历结束也没找到符合条件的，返回-1
var search = function (nums, target) {
    if (!nums.length) return -1
    let left = 0
    let right = nums.length - 1
    let mid = 0
    while (left <= right) {
        mid = parseInt((left + right) / 2)
        if (nums[mid] === target) {
            return mid
        }
        if (nums[left] <= nums[mid] && (target < nums[left] || target > nums[mid])) {
            left = mid + 1
        } else if (nums[left] > target && target > nums[mid]) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return -1
};
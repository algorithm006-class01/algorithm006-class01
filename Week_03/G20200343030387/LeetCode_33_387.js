/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
// 二分查找
// 元素经过旋转后，不再是全局单调递增，但旋转点的左右部分还是递增的，且递增方向一致；
// [nums[0], mid]
//   如果 nums[0] < mid，表示这部分递增，target < nums[0] 或 target > mid，命中后半部分；
//   如果 nums[0] > mid，表示这部分不是递增，target < nums[0] 且 target > mid，命中后半部分；
// 否则，命中前半部分；
// 排除到只剩下一个元素时，判断其值是否与target相等，是则返回其索引，否则返回-1
var search = function (nums, target) {
    if (!nums.length) return -1
    let left = 0
    let right = nums.length - 1
    let mid = 0
    while (left < right) {
        mid = parseInt((left + right) / 2)
        if (nums[0] <= nums[mid] && (target < nums[0] || target > nums[mid])) {
            left = mid + 1
        } else if (nums[0] > target && target > nums[mid]) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left === right && nums[left] === target ? left : -1
};
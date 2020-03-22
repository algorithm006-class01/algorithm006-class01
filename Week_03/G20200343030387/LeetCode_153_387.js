/**
 * @param {number[]} nums
 * @return {number}
 */
// 二分法
// 旋转后的数组，最小值在递增转变处；
// 如果找到整个是单调递增的，说明左边界即为最小值；
// 如果mid右边是单调递增，则最小值在mid的左边，否则在mid的右边；
var findMin = function (nums) {
    let left = 0
    let right = nums.length - 1
    let mid = 0
    while (left < right) {
        if (nums[left] < nums[right]) {
            return nums[left]
        }
        mid = parseInt((left + right) / 2)
        if (nums[mid] < nums[right]) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return nums[right]
};
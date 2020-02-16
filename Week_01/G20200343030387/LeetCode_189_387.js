/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    // 方法1：暴力解法
    // 循环k次移动，每次遍历整个数组且每个元素旋转一位
    // let temp, previous
    // for (let i = 0; i < k; i++) {
    //     previous = nums[nums.length - 1] // 当前要移到元素的上一个元素
    //     for (let j = 0; j < nums.length; j++) {
    //         temp = nums[j]
    //         nums[j] = previous
    //         previous = temp
    //     }
    // }

    // 方法2：额外数组
    // 空间复杂度为：O(n)
    // let newArr = []
    // let numsLen = nums.length
    // for (let i = 0; i < numsLen; i++) {
    //     newArr[(i+k)%numsLen] = nums[i]
    // }
    // for (let j = 0; j < newArr.length; j++) {
    //     nums[j] = newArr[j]
    // }

    // 方法3：多次反转数组
    // k %= nums.length // 取余数是因为数组旋转了本身长度后还是原样，所以只要余数部分就行
    // reverse(nums, 0, nums.length - 1)
    // reverse(nums, 0, k -1)
    // reverse(nums, k, nums.length - 1)

    // 方法4：切割数组末k位的元素，添加到数组头部
    nums.unshift(...nums.splice(nums.length - k))
}

// function reverse(arr, start, end) {
//     while (start < end) {
//         swap(arr, start, end)
//         start++
//         end--
//     }
// }
// function swap(arr, a, b) {
//     let temp = arr[a]
//     arr[a] = arr[b]
//     arr[b] = temp
// }

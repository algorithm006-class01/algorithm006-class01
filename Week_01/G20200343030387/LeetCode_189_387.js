/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// 方法1：暴力解法
var rotate1 = function(nums, k) {
    // 循环k次移动，每次遍历整个数组且每个元素旋转一位
    let temp, previous
    for (let i = 0; i < k; i++) {
        previous = nums[nums.length - 1] // 当前要移到元素的上一个元素
        for (let j = 0; j < nums.length; j++) {
            temp = nums[j]
            nums[j] = previous
            previous = temp
        }
    }
}

// 方法2：多数组法
// 空间复杂度：O(n)
var rotate2 = function(nums, k) {
    let newArr = []
    for (let i = 0; i < nums.length; i++) {
        newArr[(i + k) % nums.length] = nums[i]
    }
    for (let j = 0; j < newArr.length; j++) {
        nums[j] = newArr[j]
    }
}

// 方法3：多次反转数组
var rotate3 = function(nums, k) {
    var reverse = function(arr, start, end) {
        while (start < end) {
            swap(arr, start, end)
            start++
            end--
        }
    }
    var swap = function(arr, a, b) {
        let temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }
    k %= nums.length // 取余数是因为数组旋转了本身长度后还是原样，所以只要余数部分就行
    reverse(nums, 0, nums.length - 1)
    reverse(nums, 0, k - 1)
    reverse(nums, k, nums.length - 1)
}

// 方法4：切片替换
// 切割数组末k位的元素，添加到数组头部
var rotate = function(nums, k) {
    nums.unshift(...nums.splice(nums.length - k))
}

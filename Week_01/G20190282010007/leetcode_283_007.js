// 题目: 两数之和
/**
 * 题目描述：
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */

 // 解题语言: javaScript

 // 解题

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    // 标记0的下标位置
    let j = 0
    // 循环数组
    for (let i = 0; i < nums.length; i++) {
        // 当前元素是否为零，为0则不做任何操作
        if (nums[i] != 0) {
            // 当前元素不为零，判断上一个0的下标位置是否与当前元素下标位置相同
            if (i != j) {
                // 当0的标记位与当前原始不同时，将两者交换
                // nums[j] = nums[i]
                // nums[i] = 0
                // 尝试使用es6的交换方法
                [nums[j], nums[i]] = [nums[i], nums[j]]
            }
            j++
        }
    }
};
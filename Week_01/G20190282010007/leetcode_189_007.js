// 题目：旋转数组
/*
 * 题目描述：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
*/

// 解题语言： JavaScript

// 解题
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    for (let i = 1; i <= k; i++) {
        // 每向右走一步，即将数组最末尾元素移动到数组最前方
        // Array.pop(), 移除数组最后一位元素，将数组长度-1，并返回所移除的元素值
        // Array.unshift(), 向数组的首位插入一个元素
        nums.unshift(nums.pop())
    }
    return nums
};
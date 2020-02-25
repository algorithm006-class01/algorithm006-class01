// 题目: 合并两个有序数组
/**
 * 题目描述：
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 */

 // 解题语言: javaScript

 // 解题
   
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    // 将nums2中的元素合并到nums1中
    for (var i = 0;i<nums2.length;i++) nums1[m+i] = nums2[i];
    // Array.sort()，对数组内容进行排序
    nums1.sort(function (a,b) {
        return a-b
    })
};
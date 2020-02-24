/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// 1.每次右移一个位置，进行k次。时间复杂度：O(K*N) 空间复杂度：O(1)
// var rotate = function(nums, k) {
//     for (let i = 0; i < k; ++i) {
//         let tmp = nums[nums.length - 1];
//         for (let j = nums.length - 2; j >= 0; --j)
//             nums[j + 1] = nums[j];
//         nums[0] = tmp;
//     }
// };

// 2.新建临时数据存储结果。时间复杂度：O(n) 空间复杂度：O(n)
// var rotate = function(nums, k) {
//     let arr = [];
//     let len = nums.length;
//     for (let i = 0; i < len; ++i) {
//         arr[(i + k) % len] = nums[i];
//     }
// 
//     for (let i = 0; i < len; ++i) {
//         nums[i] = arr[i];
//     }
// }

// 3.翻转数组，然后分别翻转前k个元素和后面len - k个元素。时间复杂度：0(n) 空间复杂度：0(1)
var rotate = function (nums, k) {
    k = k % nums.length;
    reverse(nums, 0, nums.length);
    reverse(nums, 0, k);
    reverse(nums, k, nums.length);
}

var reverse = function(nums, start, end) {
    let L = start, R = end - 1;
    while (L < R) {
        let tmp = nums[L];
        nums[L] = nums[R];
        nums[R] = tmp;

        L++; R--;
    }
}

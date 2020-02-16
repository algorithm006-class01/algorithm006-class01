/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 * 双指针法
 */
var moveZeroes = function(nums) {
    if (nums.length <= 1) return;
    // 慢指针
    let pos = 0;
    // 将所有不为 0 的移到左边，并记录末尾所有 0 的第一个的位置
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] !== 0) nums[pos++] = nums[i];
    }
    // 将末尾应该为 0 的置为 0
    while (pos < nums.length) {
        nums[pos++] = 0;
    }
}

const nums = [0, 1, 0, 3, 12];
moveZeroes(nums);
// 预期 [1, 3, 1, 0, 0, 0, 0]

console.log(nums);


/**
 * 双指针
 * 指针：
 * 1. 将非 0 树放在前面
 * 2. 记录末尾 0 的开始位置
 * 
 * 第一步：将不为 0 的放到前面，记录指针变化
 * insertPos    i    nums
 *     0        0    [0, 1, 0, 3, 12]
 *     1        1    [1, 1, 0, 3, 12]
 *     1        2    [1, 1, 0, 3, 12]
 *     2        3    [1, 3, 0, 3, 12]
 *     3        4    [1, 3, 12, 3, 12]
 * 
 * 第二步：将末尾其它数据置为 0     
 * insertPos       nums
 *     3           [1, 3, 12, 0, 12]
 *     4           [1, 3, 12, 0, 0]
 *  
 */


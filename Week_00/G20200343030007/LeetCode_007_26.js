/**
 * @param {number[]} nums
 * @return {number}
 * 双指针法 
 */
var removeDuplicates = function (nums) {
    if (nums.length <= 1) return nums.length;
    // 定义慢指针
    let pos = 0;

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] !== nums[pos]) {
            // 每次将 pos 指针对应位置的第二位作为不重复项
            nums[pos + 1] = nums[i];
            pos++;
        }
    }

    return pos + 1;
};


// 预期：[1, 2, 3]
// var nums = [1, 1, 1, 2, 2, 3]
// 返回: 3

// const result = removeDuplicates(nums);
// console.log(nums, result);

/**
 * 优化一下 
 */
var removeDuplicates2 = function (nums) {
    if (nums.length <= 1) return nums.length;
    // 定义慢指针
    let pos = 0;

    for (let i = 1; i < nums.length; i++) {
        // 会不会出现数组越界情况，不会，因为当前代码最大执行 5 次， ++pos 最大执行 5 次，
        // 要是越界，pos = 6 ，但这一步时，for 循环已经结束
        if (nums[i] !== nums[pos]) nums[++pos] = nums[i];
    }

    return pos + 1;
};

var nums1 = [1, 2, 3, 4, 5, 6]
const result1 = removeDuplicates2(nums1);
console.log(nums1, result1);



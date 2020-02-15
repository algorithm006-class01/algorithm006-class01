/*
* address:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定数组 nums = [1,1,2],

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

你不需要考虑数组中超出新长度后面的元素。
*
*
* */

const nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4];

/**
 |--------------------------------------------------
 | Method 1:
 |--------------------------------------------------
 */
const checkDuplicate = array => {
    let checkDuplicateArray = [];
    array.forEach((el, index) => {
        if (array[index] === array[index + 1]) {
            checkDuplicateArray.push(el);
        }
    });
    return checkDuplicateArray.length;
};
const removeDuplicate = array => {
    array.sort((a, b) => a - b);
    array.forEach((el, index) => {
        if (array[index] === array[index + 1]) {
            array.splice(index, 1);
        }
    });
    if (checkDuplicate(array) > 0) {
        removeDuplicate(array);
    }
    return array;
};
//console.log(removeDuplicate(nums));


/*
* Method 2: 快慢指针
* */
const removeDuplicate4 = (nums) => {
    if (nums.length === 0) return 0;
    let i = 0;
    for (let j = 1; j < nums.length; j++) {
        if (nums[j] !== nums[i]) {
            i++;
            nums[i] = nums[j];
        }
    }
    while (nums.length !== i + 1) {
        nums.splice(i + 1, 1)
    }
    return i + 1;
};
console.log(removeDuplicate4(nums));

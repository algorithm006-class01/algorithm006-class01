/*
 |address: https://leetcode-cn.com/problems/two-sum/
 |--------------------------------------------------
 | Question: Given an array of integers,
 |           return indices of the two numbers such that they add up to a specific target.
 |--------------------------------------------------
 */
const nums = [3, 2, 3];
const target = 6; //should return [0,1]
/**
 |--------------------------------------------------
 | Method 1:
 |--------------------------------------------------
 */
const removeDuplicate = array => {
    array.sort((a, b) => a - b);
    array.forEach((el, index) => {
        if (array[index] === array[index + 1]) {
            array.splice(index, 1);
        }
    });
    return array;
};
const twoSum = (nums, target) => {
    let first = "";
    let sortNums = removeDuplicate([...nums]);
    for (let i = 0; i < sortNums.length; i++) {
        if (nums.includes(target - sortNums[i])) {
            first = sortNums[i];
            break;
        }
    }
    let second = target - first;
    let secondIndex = nums.lastIndexOf(second);
    let firstIndex = nums.findIndex(el => el === first);

    return [firstIndex, secondIndex];
};
console.log(twoSum(nums, target));
/**
 |--------------------------------------------------
 | Method 2: use Map
 |--------------------------------------------------
 */
const twoSum_v2 = function(nums, target) {
    const map = new Map();
    for (let i = 0; i < nums.length; i++) {
        const otherIndex = map.get(target - nums[i]);
        if (otherIndex !== undefined) return [otherIndex, i];
        map.set(nums[i], i);
        console.log("map", map);
    }
};
twoSum_v2(nums, target);

/*
* Method 3: using two loops => two pointers
* */
const twoSum3=(nums,target)=>{
    let a=0;
    let b=0;
    for (let i = 0; i <nums.length-1 ; i++) {
        for (let j = i+1; j <nums.length ; j++) {
            if(nums[i]+nums[j]===target){
                a=i;
                b=j;
                break;
            }
        }
    }
    return [a,b]
};

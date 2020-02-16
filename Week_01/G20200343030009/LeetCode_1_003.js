/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  let hashObj = {}
  // hash表法
  // 遍历一次数组，将所有元素存hash表中，再在表中查找是否存在值为target-nums[i]
  for (let i = 0; i < nums.length; i++) {
      // key存值， value存下标
      const t = target - nums[i]
      // B: 放到一次循环里
      if (hashObj.hasOwnProperty(t) && hashObj[t] !== i) {
          // 存在hash表中且不是本身元素
          return [hashObj[t], i]
      }
      hashObj[nums[i]] = i
  }
  // A: 分先后两次遍历
  // for (let i = 0; i < nums.length; i++) {
  //     const t = target - nums[i]
  //     if (hashObj.hasOwnProperty(t) && hashObj[t] !== i) {
  //         // 存在hash表中且不是本身元素
  //         return [i, hashObj[t]]
  //     }
  // }
  return []
};
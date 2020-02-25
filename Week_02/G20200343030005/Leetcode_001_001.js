/**
1. 两数之和

方法一：暴力法

暴力法很简单，遍历每个元素 x，并查找是否存 target=x1+x2 相等的目标元素。
暴力法很简单，遍历每个元素 x，并查找是否存在一个值与 target−x 相等的目标元素。
*/
var nums = [2, 7, 11, 15];
var target = 9;
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

var twoSum = function(nums, target) {
  var arr = [];
  for (var i = 0; i < nums.length - 1; i++) {
    for (var j = i + 1; j < nums.length; j++) {
      if (nums[i] + nums[j] == target) {
        arr.push(i, j);
      }
    }
  }
  return arr;
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

var twoSum = function(nums, target) {
  var arr = [];
  for (var i = 0; i < nums.length - 1; i++) {
    for (var j = i + 1; j < nums.length; j++) {
      if (nums[j] == target - nums[i]) {
        arr.push(i, j);
      }
    }
  }
  return arr;
};
console.log(twoSum(nums, target));

/**
方法二：两遍哈希表




为了对运行时间复杂度进行优化，我们需要一种更有效的方法来检查数组中是否存在目标元素。如果存在，我们需要找出它的索引。保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表。

通过以空间换取速度的方式，我们可以将查找时间从 O(n)O(n) 降低到 O(1)O(1)。哈希表正是为此目的而构建的，它支持以 近似 恒定的时间进行快速查找。我用“近似”来描述，是因为一旦出现冲突，查找用时可能会退化到 O(n)O(n)。但只要你仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)O(1)。

一个简单的实现使用了两次迭代。在第一次迭代中，我们将每个元素的值和它的索引添加到表中。然后，在第二次迭代中，我们将检查每个元素所对应的目标元素（target - nums[i]target−nums[i]）是否存在于表中。注意，该目标元素不能是 nums[i]nums[i] 本身！

作者：LeetCode
链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
*/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

var twoSum = function(nums, target) {
  var hashMap = new Map();
  for (var i = 0; i < nums.length; i++) {
    hashMap.set(nums[i], i); // [值value,索引index]
  }

  console.log(hashMap);
  var arr = [];
  for (var i = 0; i < nums.length; i++) {
    var hash_key = target - nums[i];
    // 注意，该目标元素不能是 nums[i]本身！
    if (hashMap.has(hash_key) && hashMap.get(hash_key) != i) {
      arr.push(i, hashMap.get(hash_key));
      return arr;
    }
  }
  //   return arr;
};
console.log(twoSum(nums, target));

/**
不能用
if (hashMap.has(hash_key) && hash_key != nums[i]) {  
  arr.push(i, hashMap.get(hash_key));  
  return arr;  
}  

输入：[3,3]  6 预期：[0,1] 用例通过不了
*/

/**
方法三：一遍哈希表
事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。

作者：LeetCode
链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/

*/
var nums = [3, 2, 4];
// var nums = [3, 3];
var target = 6;
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

var twoSum = function(nums, target) {
  var hashMap = new Map();
  var arr = [];
  for (var i = 0; i < nums.length; i++) {
    var hash_key = target - nums[i];
    if (hashMap.has(hash_key)) {
      arr.push(hashMap.get(hash_key), i);
      return arr;
    }
    hashMap.set(nums[i], i); // [值value,索引index]
  }
  console.log(hashMap);
  console.log(arr);
  return arr;
};
console.log(twoSum(nums, target));

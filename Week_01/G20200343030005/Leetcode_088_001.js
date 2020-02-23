// 88. 合并两个有序数组

/**
 * @param {number[]} arr1
 * @param {number} m
 * @param {number[]} arr2
 * @param {number} n
 * @return {void} Do not return anything, modify arr1 in-place instead.
 */

var merge = function(arr1, m, arr2, n) {
  // arr1 = arr1.splice(0, m);// arr1 地址已经变了
  // 不改变arr1的地址，需要把m 后面的数据都删除掉
  arr1.splice(m, arr1.length - m);
  arr2 = arr2.splice(0, n);

  arr1.splice(arr1.length, 0, ...arr2);

  arr1.sort((n1, n2) => n1 - n2);

  return arr1;
};

/**
 * @param {number[]} arr1
 * @param {number} m
 * @param {number[]} arr2
 * @param {number} n
 * @return {void} Do not return anything, modify arr1 in-place instead.
 */

var merge = function(arr1, m, arr2, n) {
  //将nums2中的元素合并到nums1中
  var i = 0;
  while (i < n) {
    arr1[m++] = arr2[i++];
  }
  arr1.sort((n1, n2) => n1 - n2);
  return arr1;
};

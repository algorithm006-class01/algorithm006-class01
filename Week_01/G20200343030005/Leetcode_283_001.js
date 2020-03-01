/**
给定一个数组 arr，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。


问题的两个要求是：
将所有 0 移动到数组末尾。
所有非零元素必须保持其原始顺序。
 */

/**
 * @param {number[]} arr
 * @return {void} Do not return anything, modify nums in-place instead.
 */

var moveZeroes = function(arr) {
  //1、判断0 删除，统计0的个数count
  //2、最后一位添加count个0
  let count = 0;
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] === 0) {
      arr.splice(i--, 1);
      count++;
    }
  }

  if (count) {
    for (var i = 0; i < count; i++) {
      arr.push(0);
    }
  }
  return arr;
};

/**
 * @param {number[]} arr
 * @return {void} Do not return anything, modify nums in-place instead.
 */

var moveZeroes = function(arr) {
  //1、判断0 删除，添加到0的数组中
  //2、追加到原数组
  var zeroArr = [];
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] === 0) {
      arr.splice(i--, 1);
      zeroArr.push(0);
    }
  }

  arr.push(...zeroArr);
  return arr;
};

/**
 * @param {number[]} arr
 * @return {void} Do not return anything, modify nums in-place instead.
 */

var moveZeroes = function(arr) {
  //1、判断0 删除
  //2、最后一位添加0

  var n = arr.length;

  for (var i = 0; i < n; i++) {
    if (arr[i] === 0) {
      arr.splice(i--, 1); // 删除0
      arr[arr.length] = 0; // 最后一位添加0
      console.log(i, arr);
      n--;
    }
  }
  return arr;
};

/**
 * @param {number[]} arr
 * @return {void} Do not return anything, modify nums in-place instead.
 */

var moveZeroes = function(arr) {
  // Count the zeroes
  var n = arr.length;
  var numZeroes = 0;
  for (var i = 0; i < n; i++) {
    //true: 1 布尔值为1
    numZeroes += arr[i] == 0;
  }

  console.log("numZeroes:", numZeroes);

  var tmp = [];
  for (var i = 0; i < n; i++) {
    if (arr[i] != 0) {
      tmp.push(arr[i]);
    }
  }
  console.log("tmp:", tmp);

  // Move all zeroes to the end
  while (numZeroes--) {
    tmp.push(0);
  }
  console.log("tmp:", tmp);

  // Combine the result
  for (var i = 0; i < n; i++) {
    arr[i] = tmp[i];
  }
  return arr;
};
/** 

方法二：空间最优，操作局部优化（双指针）
这种方法与上面的工作方式相同，即先满足一个需求，然后满足另一个需求。它以一种巧妙的方式做到了这一点。上述问题也可以用另一种方式描述，“将所有非 0 元素置于数组前面，保持它们的相对顺序相同”。
这是双指针的方法。由变量 “cur” 表示的快速指针负责处理新元素。如果新找到的元素不是 0，我们就在最后找到的非 0 元素之后记录它。最后找到的非 0 元素的位置由慢指针 “lastnonzerofoundat” 变量表示。当我们不断发现新的非 0 元素时，我们只是在 “lastnonzerofoundat+1” 第个索引处覆盖它们。此覆盖不会导致任何数据丢失，因为我们已经处理了其中的内容（如果它是非 0 的，则它现在已经写入了相应的索引，或者如果它是 0，则稍后将进行处理）。
在 “cur” 索引到达数组的末尾之后，我们现在知道所有非 0 元素都已按原始顺序移动到数组的开头。现在是时候满足其他要求了，“将所有 0 移动到末尾”。我们现在只需要在 “lastnonzerofoundat” 索引之后用 0 填充所有索引。
C++


作者：LeetCode
链接：https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode/

 */

/**
 * @param {number[]} arr
 * @return {void} Do not return anything, modify nums in-place instead.
 */

var moveZeroes = function(arr) {
  console.log("1arr:", arr);
  // 将所有非 0 元素置于数组前面，保持它们的相对顺序相同
  var lastNonZeroFoundAt = 0;
  for (var i = 0; i < arr.length; i++) {
    if (arr[i] != 0) {
      arr[lastNonZeroFoundAt++] = arr[i];
    }
  }

  console.log("2arr:", arr, lastNonZeroFoundAt);

  // for (var i = lastNonZeroFoundAt; i < arr.length; i++) {
  //   arr[i] = 0;
  // }

  arr.fill(0, lastNonZeroFoundAt, arr.length);

  return arr;
};

/**
方法三：最优解
前一种方法的操作是局部优化的。例如，所有（除最后一个）前导零的数组：[0，0，0，…，0，1]。对数组执行多少写操作？对于前面的方法，它写 0 n-1n−1 次，这是不必要的。我们本可以只写一次。怎么用？… 只需固定非 0 元素。

最优方法也是上述解决方案的一个细微扩展。一个简单的实现是，如果当前元素是非 0 的，那么它的正确位置最多可以是当前位置或者更早的位置。如果是后者，则当前位置最终将被非 0 或 0 占据，该非 0 或 0 位于大于 “cur” 索引的索引处。我们马上用 0 填充当前位置，这样不像以前的解决方案，我们不需要在下一个迭代中回到这里。

换句话说，代码将保持以下不变：

慢指针（lastnonzerofoundat）之前的所有元素都是非零的。
当前指针和慢速指针之间的所有元素都是零。
因此，当我们遇到一个非零元素时，我们需要交换当前指针和慢速指针指向的元素，然后前进两个指针。如果它是零元素，我们只前进当前指针。

作者：LeetCode
链接：https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode/

*/

function swap(arr, m, n) {
  var tmp = arr[m];
  arr[m] = arr[n];
  arr[n] = tmp;
}
/**
 * @param {number[]} arr
 * @return {void} Do not return anything, modify nums in-place instead.
 */

var moveZeroes = function(arr) {
  for (var lastNonZeroFoundAt = 0, cur = 0; cur < arr.length; cur++) {
    // 当前元素!=0，就把其交换到左边，等于0的交换到右边
    if (arr[cur] != 0) {
      swap(arr, lastNonZeroFoundAt++, cur);
    }
  }
  return arr;
};
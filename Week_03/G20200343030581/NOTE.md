##使用二分查找，寻找一个半有序数组[4, 5, 6, 7, 0, 1, 2] 中间无序的地方
将这个数组分成两部分来看，[4,5,6,7] 和 [0,1,2]。这两部分都是有序的，只有值为0的位置比前一个位置小，值为7的位置比后一个位置大。那么我们只要找出这样的一个位置，就能找到答案。

```javascript
var find = function (nums) {
	let low = 0,
		 high = nums.length - 1;
	while (low <= high) {
		let mid = low + ((high - low) >> 1);
		
		// 如果位置mid的值比后一个大
		if (nums[mid] > nums[mid + 1])
			return mid + 1;
		// 如果位置mid的值比前一个小
		if (nums[mid] < nums[mid - 1])
			return mid;
			
		if (nums[mid] >= nums[0]) {
			// 0到mid这个区间是单调递增区间
			// 无序的位置在后半部分
			low = mid + 1;
		} else {
			high = mid - 1;
		}
	}
	
	return -1;
}
```
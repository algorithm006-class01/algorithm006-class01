# 学习笔记
## Bloom Filters
* 空间效率、查询性能远远超过一般算法，如hash；
* 可以判断对象是否不存在，但不能完全确定是否存在；
* 应用在数据库、分布式系统的缓存层场景；
### 代码示例
```python
from bitarray import bitarray 
import mmh3 

class BloomFilter: 
	def __init__(self, size, hash_num): 
		self.size = size 
		self.hash_num = hash_num 
		self.bit_array = bitarray(size) 
		self.bit_array.setall(0) 

	def add(self, s): 
		for seed in range(self.hash_num): 
			result = mmh3.hash(s, seed) % self.size 
			self.bit_array[result] = 1 

	def lookup(self, s): 
		for seed in range(self.hash_num): 
			result = mmh3.hash(s, seed) % self.size 
			if self.bit_array[result] == 0: 
				return "Nope" 
		return "Probably" 

bf = BloomFilter(500000, 7) 
bf.add("dantezhao") 
print (bf.lookup("dantezhao")) 
print (bf.lookup("yyj")) 
```

## LRU cache
* 最近最少使用（读或写）的就放到最后，超出缓存大小限制时，淘汰掉最后的；
* Hash Table(hash表) + Double Linkedlist(双向链表) 实现；
* 查询O(1)，修改O(1)

## 排序
###  归并排序
* 每次将数组分为左右两部分，分别排序后再merge；
* merge需要额外的存储空间

### 快速排序
* 每次取priot，通过partition将数组分为左边小于priot的部分，右边大于priot的部分，最终整个数组有序；
* partition的空间复杂度为O(1)

### 各个排序算法的代码
```js

// 选择排序
// 每次找最小值，然后放到待排序数组的起始位置
const selectSort = (arr) => {
    const arrLen = arr.length
    let minIndex, tmp
    for (let i = 0; i < arrLen; i++) {
        minIndex = i
        for (let j = i + 1; j < arrLen; j++) {
            if (arr[minIndex] >= arr[j]) {
                minIndex = j
            }
        }
        tmp = arr[i]
        arr[i] = arr[minIndex]
        arr[minIndex] = tmp
    }
    return arr
}

// 插入排序
// 从前往后构建序列，前面是已排序，每次拿一个未排序数据在已排序数据中从后往前找位置插入
// 插入排序在实现上，通常采用in - place排序（即只需用到O(1)的额外空间的排序），
// 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间
const insertSort = (arr) => {
    let prevIndex, current
    for (let i = 1; i < arr.length; i++) {
        prevIndex = i - 1
        current = arr[i]
        while (prevIndex >= 0 && arr[prevIndex] > current) {
            arr[prevIndex + 1] = arr[prevIndex--]
        }
        arr[prevIndex + 1] = current
    }
    return arr
}

// 冒泡排序
// 嵌套循环，每次查看相邻元素逆序则交换位置
// 外层循环每完成一次，会有一个大元素被排在末尾，像气泡一样往上到顶部
const bubbleSort = (arr) => {
    for (let i = 0; i < arr.length; i++) {
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[i] > arr[j]) {
                const tmp = arr[i]
                arr[i] = arr[j]
                arr[j] = tmp
            }
        }
    }
    return arr
}

// 快速排序
// 在数组任意取一标杆元素pivot，将小于pivot的元素放在其左边，大于的放右边
// 递归上述过程，最终排序完成
const quickSort = (arr, start, end) => {
    if (start >= end) return arr
    const pivot = partion(arr, start, end)
    quickSort(arr, start, pivot - 1)
    quickSort(arr, pivot + 1, end)
    return arr
}
function partion(arr, start, end) {
    let counters = start, pivot = end
    // counters记录比pivot小的元素中的最大索引值+1
    for (let i = start; i < end; i++) {
        if (arr[i] < arr[pivot]) {
            const tmp = arr[i]
            arr[i] = arr[counters]
            arr[counters] = tmp
            counters++
        }
    }
    // 最后将privot与counters所在位置交换，就达到pivot左边都是比它小的元素，右边都是比它大的
    const tmp = arr[counters]
    arr[counters] = arr[pivot]
    arr[pivot] = tmp
    return counters
}

// 归并排序
// 从索引中点将数组切割两等份，递归下去，一直到不可切分
// 逐层合并其中的子数组，最终达到有序
const mergeSort = (arr, start, end) => {
    if (start >= end) return arr
    const mid = parseInt((start + end) / 2)
    mergeSort(arr, start, mid)
    mergeSort(arr, mid + 1, end)
    merge(arr, mid, start, end)
    return arr
}
function merge(arr, mid, start, end) {
    let k = 0, tmp = [], i = start, j = mid + 1
    while (i <= mid && j <= end) {
        tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++]
    }
    while (i <= mid) tmp[k++] = arr[i++]
    while (j <= end) tmp[k++] = arr[j++]

    for (let p = 0; p < tmp.length; p++) {
        arr[start + p] = tmp[p]
    }
}

// 堆排序
// 1. 构建大顶堆
// 2. 不断从堆顶取出元素与堆尾互换，再排除堆尾调整堆
// 3. 递归执行2，直到堆为空
function heapSort(arr) {
    const length = arr.length
    if (length < 1) return arr

    // 构建大顶堆
    for (let i = parseInt(length / 2) - 1; i >= 0; i--) {
        heapify(arr, length, i)
    }

    // 步骤2，3
    for (let j = length - 1; j >= 0; j--) {
        swap(arr, 0, j)
        heapify(arr, j, 0)
    }
    return arr
}
function heapify(arr, length, i) {
    let largest = i
    let left = 2 * i + 1
    let right = 2 * i + 2
    if (left < length && arr[left] > arr[largest]) {
        largest = left
    }
    if (right < length && arr[right] > arr[largest]) {
        largest = right
    }
    if (largest !== i) {
        swap(arr, i, largest)
        heapify(arr, length, largest)
    }
}
function swap(arr, i, j) {
    const tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp
}

const assert = require('assert')
const sortFn = [insertSort, selectSort, bubbleSort, quickSort, mergeSort, heapSort]
// const sortFn = [insertSort]
const randomArr = Array(1000).fill(0).map(i => parseInt(Math.random() * 1000))
const testTasks = [
    {
        input: [2, 3, 1, 6, 1], output: [1, 1, 2, 3, 6]
    },
    {
        input: [-2, 3, 1, 6], output: [-2, 1, 3, 6]
    },
    {
        input: [0], output: [0]
    },
    {
        input: [], output: []
    },
    {
        input: randomArr, output: randomArr.sort((a, b) => a - b)
    }
]
for (let fn of sortFn) {
    console.time(`${fn.name}`)
    for (let t of testTasks) {
        assert.deepStrictEqual(fn(t.input.slice(0), 0, t.input.length - 1), t.output)
    }
    console.timeEnd(`${fn.name}`)
}

```

* 日志输出
* insertSort: 0.993ms
* selectSort: 3.574ms
* bubbleSort: 2.501ms
* quickSort: 3.911ms
* mergeSort: 1.629ms
* heapSort: 1.944ms

这里有个不懂的地方，快排、归并居然比插入要慢不少，而且数组更长的时候，差别更明显。
时间复杂度来看，快排、归并肯定比插入要快，但考虑js的语言动态特性，对于递归会不会消耗更多的其它资源，导致处理更慢？
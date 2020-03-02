# 学习笔记
## 递归、分治、回溯
* 分解子问题
* 找重复性
* 三者的代码实现很相似
* 用递归代码实现逻辑，可以类比n叉状态树的深度优先遍历

## 深度、广度优先搜索
### 深度优先搜索（DFS）
* 比较反常识；
* 类比二叉树的遍历；
* 代码模板
递归：
```
visited = set() 

def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 

	visited.add(node) 

	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```

自定义栈
```
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```

### 广度优先搜索（BFS）
* 符合常识
* 类似公司、团体组织的职位分层
* 代码模板
```
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
```

## 贪心算法
* 每一步都求局部最优，最终达到全局最优；
* 适用场景较少；
* 代码实现逻辑简单，判断是否可用贪心算法更重要；
* 与动态规划的区别在于，它不能回退中间结果，而动态规划可以；

## 二分查找
### 使用的前提
1. 目标函数单调性（递增或递减）；
2. 存在上下界；
3. 能够通过索引访问；

### 代码模板
```
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```

## 作业题
> 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

### 解题思路
1. 半有序数组相当于是一个升数组旋转一次得到；
2. 中间无序的地方相邻元素分别是该数组的最大与最小值，且与前后片段的单调性相反；
3. 用二分法查找数组的最大或最小值，则得到无序地方的位置；
4. 找最小值，如果mid右边是单调递增，则最小值在mid的左边，否则在mid的右边，一直二分下去直到左右边界重合则边界即是所求，或者中间出现左边界的值小于右边界的值，则左边界即是所求

* 代码实现
```js
const solution = function (nums) {
    let left = 0
    let right = nums.length - 1
    let mid = 0
    while (left < right) {
        if (nums[left] < nums[right]) {
            return left
        }
        mid = parseInt((left + right) / 2)
        if (nums[mid] > nums[right]) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}

const test = function () {
    if (solution([4, 5, 6, 7, 0, 1, 2]) !== 4) {
        throw new Error('error')
    }
    if (solution([4, 5, 6, 0, 1, 2]) !== 3) {
        throw new Error('error')
    }
    if (solution([4, 1, 2]) !== 1) {
        throw new Error('error')
    }
    if (solution([4, 5, 1, 2]) !== 2) {
        throw new Error('error')
    }
    console.log('success')
}
test()
```


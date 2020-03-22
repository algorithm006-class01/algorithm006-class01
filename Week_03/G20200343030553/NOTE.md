学习笔记

## 第八课  分治、回溯

本质上都是递归

分治：对一个问题划分为多个子问题split，最后合并子问题结果merge。（和普通递归区别，最后需要合并子问题结果）

n的x幂问题（[50. Pow(x, n)](https://leetcode-cn.com/problems/powx-n/)）、求众数（[169. 多数元素](https://leetcode-cn.com/problems/majority-element/)）

```python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 
  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 
  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …
  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
  # revert the current level states
```

回溯：采用试错的思想，分步的解决一个问题，当解决过程中发现当前分步答案错误则取消该分支。

八皇后问题、数组组合问题（[78. 子集](https://leetcode-cn.com/problems/subsets/)、[17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)）。

## 第九课 深度优先、广度优先搜索：

DFS（深度优先）：分为前序、中序、后序搜索；可通过递归或栈实现； 其中对于图结构，遍历是增加visited集合，用于存放已访问节点，防止重复访问。

```python
递归写法
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

```python
非递归写法
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

BFS（广度优先）：层级遍历；可通过queue实现；其中对于图结构，遍历是增加visited集合，用于存放已访问节点，防止重复访问。

```python

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

BFS（[102. 二叉树的层次遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)、[127. 单词接龙](https://leetcode-cn.com/problems/word-ladder/)）、DFS（[22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)）

## 第十课 贪心算法

贪心算法：每一步选择中都采取当前状态下最好或最优的选择，从而导致全局最优，比较高效；问题是全局并不一定最优；从开始贪心、从最后贪心

贪心 & 回溯 & 动态规划

贪心：当下局部最优

回溯：能够回退

动态规划：最优判断+回退

最小生成树、找零问题（[322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)、[860. 柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/)、[455. 分发饼干](https://leetcode-cn.com/problems/assign-cookies/)）



## 二分查找

二分查找：三个条件 1、目标函数单调性 2、存在上下界 3、能够通过索引访问

```python
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

求平方根（[69. x 的平方根](https://leetcode-cn.com/problems/sqrtx/)）、半有序数组
# Week 03 学习笔记
## Divide & conquer and Backtracking
```python
def divide_conquer(problem,param1,param2,…):
    # recursion terminator
    if problem is None:
        print_result
        return

    #prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem,data)
    
    #conquer subproblems (drill down)
    subresult1 = self.divide_conquer(subproblem[0],p1,…)
    subresult2 = self.divide_conquer(subproblem[1],p1,…)
    subresult3 = self.divide_conquer(subproblem[2],p1,…)
    ...

    #process and generate the final result 与范型递归不同的地方，就是最后结果需要组合
    result = process_result(subresult1, subresult2, subresult3,…)
```

`Leetcode 50. pow(x,n)`
1. Brute force O(n)
2. Divide & conquer<br>
    * 注意n为负数的情况<br>
    * Subproblem: pow(x,n/2) <br>
    * Merge:<br>
        ``` python
        if n % 2 == 1:
            result = subresult * subresult * x
        else: result = subresult * subresult 
        ```
3. 牛顿迭代

`Leetcode 78 subset`: 注意迭代的写法

`Leetcode N-queen`:
注意左右对角线的表达方式 (注意表格数值的增长方向与平常坐标轴不同）<br>
|   | 0 | 1 | 2 | 3 |
|---|---|---|---|---|
| **0** |   |   |   |   |
| **1** |   |   |   |   |
| **2** |   |   |   |   |
| **3** |   |   |   |   |

`\` 对角线： x-y = const<br>
`/` 对角线： x+y = const

## Traversal
- Every node needs to be accessed
- Every node can just be accessed once

### DFS template
```python
visited = set()
def dfs(node, visited):
    if node in visited:
        return
    visited.add(node)
    # process current node here
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node,visited)
```

### BFS template
BFS use `queue`
```python
def BFS(graph, start, end):
    queue = []
    queue.append(start)
    visited = set()
    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
    # other processing work
    ...
```
## Greedy
**Difference between Greedy and Dynamic Programming**<br>
`Geedy`:  当下做局部最优判断，不能回退<br>
`动态规划`：最优判断并保存运算结果 + 回退

一般能用贪心解决的问题都为最优，但是条件需要比较特殊：子问题的最优解能够递推到最终问题的最优解

## 二分查找
前提条件：
1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible）

### Binary Search Template
```python
left, right = 0, len(array) - 1
while left <= right:
    mid = (left + right)/2
    if array[mid] == target:
        #find the target
        break or return result
    elif array[mid] < target: 
        # (假设上升）
        left = mid + 1 （integer的情况）
    else:
        right = mid - 1
```
**注意有时候 (left+right)/2 有可能会越界 —> `left + (right - left)/2`**

`Leetcode 33 search in rotated sorted array`
1. Brute force: resume O(log N) -> ascending -> binary search: O(log N)
2. Binary search
    * Monotone
    * Boundary
    *  Index
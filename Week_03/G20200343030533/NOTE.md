# 学习笔记

## 分治、回溯

两者的本质就是递归。

碰到题目，就去找重复性。重复性分为最近重复性和最优重复性。最优重复性也可以认为是最优子结构，用动态规划来完成。

基本思路: 找重复性，分解问题，最后合并。

本质上是机器只能做循环和逻辑判断，因此就需要把大问题拆分成重复的问题

### 分治

为什么可以分解子问题？大问题或者复杂问题之所以复杂和庞大，就是因为它是由许多小问题构成。在一般人眼里复杂问题就是一个问题，但是在专业人士里面，这个复杂问题就能分成小问题，庖丁解牛就是这个道理。

代码模版

```python
def divide_conquer(problem, param1, param2, ...):
    # recursion terminator
    if problem in None:
        print_result
        return
    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)
    # conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0], p1, ...)
    subresult2 = self.divide_conquer(subproblems[0], p1, ...)
    subresult3 = self.divide_conquer(subproblems[0], p1, ...)
    ...
    # process and generate the final result
    result = process_result(subresult1, subresult2, subresult3)

```

代码和泛形递归的差异区别: 多了一步合并子结果

- 问题解决标志: 不存在子问题
- 处理当前逻辑: 将大问题分成子问题
- 下探一层: 处理子问题
- 结果组装

分治的关键，**如何分解问题**， **如果合并结果**，**如何保证子结果**

不要下探太多层，不要人肉递归（你会很累）

### 回溯

回溯: 归去来兮

不断得在每一层就去试，如果错了就返回，如果没有出错就继续下探。

### 题目部分

题目1: pow(x,n)

审题, x和n的取值问题

解题方法

1. 暴力法, for循环, O(n)
1. 分治方法,O(log n)
1. 牛顿迭代法

子问题拆解：考虑奇偶性

题目2: subset

状态重置, 参数变量发生了变化，因此需要重置。如果不希望重置，就需要在每一层拷贝一个新的列表。

题目3: 众数, 简单但高频

题目4: 电话号码的组合. 括号生成的套壳升级而已

题目5: N皇后. 回溯问题，主要考验验证当前的位置能否使用的方法

## 深度搜索，广度搜索

搜索基本就是暴力，本身没有任何智识存在。

搜索-遍历

- 每个节点都要访问一次
- 每个节点仅仅要访问一次
- 对于节点的访问顺序不限，（DFS, BFS). 优先性搜索（启发性搜索）

深度优先搜索递归模版

```python
def dfs(node):
    # already visted
    if node in visited:
        return
    visited.add(node)
    # process current node
    # ... logic here
    dfs(node.left)
    dfs(node.right)
```

非递归模版(手动模拟栈)

```python
def DFS(self, tree):
    if tree.root is None:
        return []

    visited, stack = [], [tree.root]
    while stack:
        node = stack.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)
    # other processing work
```

如果有大于两个子节点

```python
visited = set()
def DFS(node, visited):
    if node in visited: # terminator
        #alredy visited
        return
    visited.add(node)
    #process current node here
    ...
    for next_node in node.children():
        if next_node not in visited:
            DFS(next_node, visited)
```

广度优先搜索模版(队列)

```python
def BFS(graph, start, end):
    queue = []
    queue.append([start])
    visted.add(start)

    while queue:
        node = queue.pop()
        visted.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
    #other processing work
    ...
```

算法步骤是:

- 先加入root
- 取出顶部节点
- 处理节点
- 获取子节点
- 在队列中加入子节点

**学习感受**: 看到stack，递归，就可以想到DFS，看到queue就想到BFS。tree可以不需要记录访问节点，graph必须得要记录访问节点。

### 题目

**二叉树层次遍历**：硅谷面试前三个考题

方法

1. BFS
1. DFS， 记住每次所在层，然后在对应层来加入内容

**括号生成**: 明明只是一个字符串，又不是树，也不是图，为啥我们认为他是深度优先搜索呢？原因是我们每个节点都会分岔，也就是递归的状态树。我们在递归的状态树进行深度优先。能否用广度优先进行处理？

**word-ladder-ii** 高频题目， 问题可以抽象成一个无向无权图， 单词作为一个节点，节点之间只差一个字母。

**岛屿数目**: 遇见岛就把岛屿给炸了， sink函数，从当前位置出发，把附近的1都变成0. 

一个技巧，上下左右的移动方法

```cpp
int dx[4] = {-1, 1,  0, 0};
int dy[4] = { 0, 0, -1, 1};
```

四面八方的移动写法

```cpp
int dx[8] = {-1,-1,-1, 0, 0, 1, 1, 1};
int dy[8] = { 1, 0,-1, 1,-1, 1, 0, -1};
```

思路: floofill, 冲水算法，看到一个1，就把附近都变成0，于是就成了DFS（深度优先了）

后面的扫雷也是DFS，看到一个E，就把四海八荒的区域都看遍。终止条件是，附近有雷。

## 贪心算法

每次是局部最优，**希望**达到全局最优。

贪心和动态规划，贪心每次选最优不回退，动态规划会**保存**结果，根据之前结果选择,从而得到全剧最优。

一旦一个问题可以用贪心法解决，那么贪心法就会是最优算法。例如最小生成树，Dijkstra

意义：高效，并且接近最佳结果，因此是一种辅助算法。

coin change: 前面硬币依次是后续硬币的倍数，[20,10,5,1], 也就是有整除关系

**使用场景**：大问题能够变成小问题，小问题的最优解能递推最终问题的最优解。子问题的最优解称之为最优子结构。

贪心的难点在于，你需要用数学的方法去证明，这个过程最重要。

另外贪心的角度也不不好找，可能是从**后往前**，也可能是**局部切入**

## 二分查找

前提

1. 单调性（不需要是严格的单调） 
1. 上下界
1. 随机访问

代码模版

```python
left, right = 0, len(array)-1
while left <= right:
    mid = left + ((right - left) >> 1)
    if array[mid] == target:
        #find the target !!
        break or return result
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid -1
```

- 先判断是否相同，相同的直接返回
- 如果left和right不是整型，就不需要`+/-1`

经验，先把代码模版放上，然后修改。

1. 暴力: 还原O(log N) -> 升序 -> 二分
2. 正解

求根公式:牛顿迭代法, r= num, 不断迭代 r = (r + num / r) // 2, 

## 思考题

查找半有序数组[4, 5, 6, 7, 0, 1, 2] 中间无序的地方

如何确定自己的位置就是无序的位置，

- 左一位小-右一位小
- 左一位大-右一位大

如果不符合，如何确定下一步的搜索范围

- a[mid]比a[0], a[high]都高，说明要往右边移动, low = mid
- a[mid]比a[0], a[high]都低，说明要往左边移动, high =mid



## 其他

cpp动态数组

```cpp
int *foo = new int [5];
delete foo; //释放单一内存
delete[] foo; //释放一组内存
//或者用array
array<int, 3> arr; //大小为3
arr.fill(0);//填充0
```

小技巧，数组声明为静态或者全局默认都是0

```cpp
static int *foo = new int[5];
```

array其实就是数组的封装而已，固定大小，不能向vector一样动态扩容。

set的常用操作

```cpp
set<int> s; //empty set
s.insert(20); //插入元素
s.count(20); //统计元素是否在

```

写`C++`代码的时候，类似于`function(vec.push_back(num))` 好像是不允许的，也就是不能在参数里面调用成员函数

queue的常用操作

```cpp
std::queue<int> myqueue;
queue.push(); //入队
queue.pop();  //出队
queue.front(); //查看顶部元素
queue.empty(); //是否为空
```

stack的常用操作

```cpp
std::stack<int> mystack;
mystack.push(); //入队
mystack.pop();  //出队
mystack.front(); //查看顶部元素
mystack.empty(); //是否为空
```

双端队列, deque

```cpp
std::deque<int> mydeque(4,100);// 初始化4个元素，分别为100
mydeque.push_back();
mydeque.pop_back();
mydeque.push_front();
mydeque.pop_front();
mydeque.back();
mydeque.fron();
```

抑或的用法`^`: 参加运算的二进制位置相同为0，否则为1.

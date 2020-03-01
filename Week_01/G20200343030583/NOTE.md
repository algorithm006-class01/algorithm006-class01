## 学习笔记 week01 Summary
### Array: 
- Prepend: O(1) [*]
- Append: O(1)
- Lookup: O(1)
- Insert: O(n)
- Delete: O(n)

### LinkList:
- Prepend: O(1)
- Append: O(1)
- Lookup: O(n)
- Insert: O(1)
- Delete: O(1)

### Skip List:
升维 + 空间换时间 <br>
Add index for some node: 一级索引，二级索引(more coarse)，……，多级索引 <br>
时间复杂度 O(log n) <br>
维护成本较高。添加和删除都要重新对索引进行修改 <br>
空间复杂度 O(n) <br>

Q70 <br>
！找最近 重复子问题 <br>
第三级台阶走法：第一级台阶 + 2步； 第二级台阶 + 1步 <br>
f(3) = f(1) + f(2) <br>
f(4) = f(2) + f(3) <br>
->fibonacci <br>

懵逼时候：
1. 能不能暴力解？基本情况 <br>
2. 找最近重复子问题 （重复性）

#### 双指针方法
1.可能要排序？<br>
2.向中缩进 （根据题目条件判断缩进策略）<br>
E.g, 3 sums and 两柱中间面积 <br>
\* 快慢指针 （检测链表有环）

### deque 双端队列

### Priority queue
Push: O(1) <br> 
Pop: O(log n) 按照元素优先级取出 <br>
底层具体实现的数据结构较为多样和复杂：heap, bst, treap <br>

#### 最近相关性 -> 用栈来解决
E.g. 括号字符串的有效性 Q20

#### 先来后到 -> queue
E.g. Sliding window -> queue  Q239


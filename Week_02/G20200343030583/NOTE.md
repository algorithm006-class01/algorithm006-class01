## 学习笔记
Hash table (hash function to project<br>
Key -> value<br>
Example: LRU cache<br>
碰撞：多个元素通过链表存储<br>
Average: Search O(1), Insertion O(1), Deletion O(1)<br>
Worst: All O(n)<br>
Map and set -> python: dict & set

### 四步思考：
1. Clarification和面试官讨论
2. Possible solution -> optimal (time&space)
3. Code
4. Test cases

`Leetcode 242. valid anagram`
1. Brute force, sort string, if sorted_str equal? -> O(nlog n)
2. Hash, map -> to record frequency of every character

### 二叉树遍历：
- Pre-order: root, left, right
- In-order: left, root, right
- Post-order: left, right, root

### 二叉搜索树(binary search tree) = 有序二叉树(ordered binary tree) = 排序二叉树(sorted binary tree)
1. All the nodes on the left tree . Val < root. Val
2. All the nodes on the right tree . Val > root. Val
3. Both left and right trees are also binary search tree
- Thus **in-order -> ascending sorted array ！可以用来验证是否为BST**
- 查询，插入O(log n)
- 注意，如果是无序，查询和插入则是O(n)
- 删除：1. 叶子 -> 直接删除 2. 非叶子结点 -> 删除后，将刚好大于的结点拉上去

### 递归 recursion
```python
#Python 代码模版
Def recursion(level, param1, param2,…)
#recursion terminator 终止条件先写上
If level > MAX_LEVEL:
    process_result
	return

# process logic in current level 处理当前层的数据
process(level, data,…)

# drill down 下潜到下一层
self.recursion(level+1, p1, …)

# reverse the current level status if needed ( like global parameter) 清理当前层的状态
```
### 思维要点:
1. 不要人肉递归
2. 找最近最简方法，将其拆解成重复子问题 （重复性）
3. 数学归纳法 （初始条件成立；保证在前一个条件成立的时候，后一个也成立）

`Leetcode 爬楼梯问题`<br>
找包含所有的子问题、且没有重复计算 (mutual exclusive & complete exhaustive)的方法

`Leetcode 22. 括号生成 （只有小括号的情况`
1. 用递归去写能生成包含n个括号的各种情况的程序
2. 考虑括号合法性，在递归中即可验证：
- left 随时可以加，只要不超标，不超过n
- Right 必须之前有左括号，且左个数 > 右个数

`Thoughts from Leetcode 429. N-ary tree` <br>
BFS use queue, DFS use stack

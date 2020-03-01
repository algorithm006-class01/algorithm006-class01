# 学习笔记

## 哈希map和set

map和set都分成两种，一种是有顺序，一种没有顺序。

对于有序map，内部元素通过key进行排序(a specific strict weak ordering criterion). 内部实现，**二叉搜索树**

对于无序map(`unordered_map`)，访问速度快于有序map. 内部元素根据他们的哈希值组织成buckets（桶），可以直接根据key进行访问。

map容器重载了操作符`[]`和`=`, 使得键值对的设置更加符合直觉，也更加方便。

set和map类似，只不过只存放key，不存放value。

调用例子

```cpp
std::unordered_map<string, string> hash_table; //定义
hash_table["张三"] = "年轻司机"; //设置key-value
hash_table["李四"] = "老司机"; //设置key-value
hash_table["张三"] ; //访问已有的结果
hash_table["王五"] ; //访问不存在的元素，会新建一个元素，内容为空
hash_table.count("张三"); //计数key
hash_table.find("张三") ;// 查找，如果找不到则返回hash_table.end()
```

### 242:有效的字母异位词

注意审题，例如这道题目

- 什么异位词
- 是否大小写敏感

可能的解题方法

1. 暴力求解1，排序，判断是否相同
1. 暴力求解2，哈希表，比较每个字母出现频次

类似的题目:49题

### 1:两数之和

最大误区: 题目只做一遍

好习惯: 收藏比较好的代码，整理成代码库

## 树

树的结构用于满足人类需求，例如递归树，状态树，决策树

二叉树的遍历，前序，中序，后序，相对于根的位置

树的循环比较麻烦，递归是更好的实现。

二叉搜索树，空树也是

- 左子树的所有节点都小于根
- 右子树的所有节点都大于根
- 依次类推，也就是重复性来源

二叉搜索树 Demo，<https://visualgo.net/zh/bst>

常见操作

- 查询: O(log n)
- 插入: O(log n)
- 删除: O(log n): 如果是叶子节点，直接删除，如果不是，则找第一个大于待删除节点来替换掉要删除的节点。

最差的情况，退换成单链表

必须记住的代码

```python
def preOrder(self, root):
    if root:
        self.traverse_path.append(root.val)
        self.preOrder(root.left)
        self.preOrder(root.right)

def inOrder(self, root):
    if root:
        self.inOrder(root.left)
        self.traverse_path(root.val)
        self.inOrder(root.right)

def postOrder(self, root):
    if root:
        self.postOrder(root.left)
        self.postOrder(root.right)
        self.traverse_path(root.val)
```

### 题目

**一个误区**: 递归本身不存在效率低，效率差的问题，只要你的程序本身没有写残。递归相对于非递归，就在于递归需要额外开栈，因此在深度非常高的情况下，可能会差一些。但是目前编译器存在尾递归优化，可以认为递归和循环一样的效率。

题目用遍历做都不难，只要理解中序，前序，和后续的含义，也就是前中后是相对于根节点。

## 递归

递归本质就是循环，通过函数体来循环。

根本原因是 **汇编没有循环嵌套一说**， 比较常见的情况，就是不断跳到之前写的函数命令，循环汇编之后会递归其实差不多。

一层一层下降落，然后一层一层回来

函数参数和全局参数会在递归过程中会发生变化

代码模版

```java
public void recur(int level, int param) {

  // terminator
  if (level > MAX_LEVEL) {
    // process result
    return;
  }

  // process current logic
  process(level, param);

  // drill down
  recur( level: level + 1, newParam);

  // restore current status
 ```

核心部分

- 终止条件
- 当前层逻辑
- 下探下一层
- (可选)清理当前环境

思维要点:

1. 不要人肉递归， 不要尝试绘制递归树
1. 找到最近最简的方法，将其拆解成可重复解决的问题（最近子问题）
1. 数学归纳法思维

### 爬楼梯

在第三层的时候，不再是从头思考，而是从已有的结果出发，也就是从第二层和第三层出发

### 括号的生成

先思考参数应该如何设置，自顶向下编程

然后无脑写模版

第一种思路，先把所有可能都输出了，然后在return的时候，过滤结果

第二种思路，在中间过程中就把不合法的删除，规则是右括号小于等于左括号

为什么7行代码可以解决复杂的问题，因为人脑老是习惯暴力递归，而没有思考重复性。

### 验证二叉搜索树

方法1: 根据二叉搜索树定义

方法2: 中序遍历，输出有序数组

### 二叉树最大深度和最小深度

关键是叶子节点定义，最大深度肯定是探到底，因此最后的节点必然是叶子结点。但是对于最小深度，并不是最前面的节点就算是最小深度的节点了。比如下面这颗树，虽然9和20都算出来是2，但是20不符合要求，9才是需要的节点。

```bash
    3
   / \
  9  20
    /
   15
````

因此都为空，返回+1，一个为空一个不为空，发挥不为空节点后续+1；

## 其他

Cpp的新的for循环: `for( auto str:strs )`.

新建容器vector的一种方法`vect or<string> vec(1, str)`, 结果是长度为1，默认为str的vector

**算术基本定理**，又称为正整数的唯一分解定理，即：每个大于1的自然数，要么本身就是质数，要么可以写为2个以上的质数的积，

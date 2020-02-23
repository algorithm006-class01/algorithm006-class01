# 学习笔记

## 哈希表
构造hash函数；
防止hash碰撞：扩容或链表节点；

### java12 HashMap put/get源码分析
* HashMap基本数组结构，元素是Node类，继承Map，记录节点的值、hash等信息；
* get 每次操作都需要执行hash方法，判断key是否存在，存在则返回Node的值，否则返回Null；
* set 每次操作都需要执行hash方法，判断key是否存在，存在则调整Node的值和hash，否则需要添加Node；
* 添加Node前需要判断当前Node数量是否赶出阈值（该值由加载因子决定），超出则增加多一倍的HashMap容量，防止hash碰撞；

## 树
* 二叉搜索树
* 前、中、后序遍历
* 一般用递归方法

## 递归
写二叉树遍历的时候，递归代码十分简洁，逻辑清晰；

### 思维要点
* 类比盗梦空间：向下递，向上归；每一层环境独立；通过某种条件回到上层，归来时能携带信息；
* 不要人肉递归（最大误区）
* 找最近重复问题，拆解成重复的子问题
* 数学归纳法思维

### 写代码代码：
* 1、递归终结条件
* 2、处理层当前逻辑
* 3、下探到下一层
* 4、清理当前层

#### 代码模板
```python
def recursion(level, param1, param2, ...): 
    # recursion terminator 
    if level > MAX_LEVEL: 
	   process_result 
	   return 

    # process logic in current level 
    process(level, data...) 

    # drill down 
    self.recursion(level + 1, p1, ...) 

    # reverse the current level status if needed
```

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
 
}
```
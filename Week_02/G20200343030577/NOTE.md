# 第2周学习心得
### 创建时间：2020-02-23 20:43
## Hash表
1. ### Hash 原理
- 利用数组的随机访问特性，通过 index = hash(key) mod 数组容量,将kv对象存放于arr[index]下，实现O(1)的随机访问特性
2. ### Hash 函数
- 常见hash函数入MD5，SHA，CRC
- hash函数特性：敏感性，稳定性，不可逆，冲突概率小
- hash表选择hash函数因数：相对简单性（hash计算需要消耗大量计算资源，量力而为），均匀性（避免hash攻击，hash随机访问降至O(n),造成服务不可用）
3. ### Hash 碰撞（散列冲突）
- 原理：hash函数总是最多产出有限max个hash串，当数据容量大于max时，必定至少存在一对相同的hash串，这就是hash碰撞
- 解决方式1:开放寻址（一维结构，找到下一个空槽，有一次线性探测，二次探测，双重散列方式，适合装载因子较小的场景）
- 解决方式2:链表法（二维结构，一维数组二维链表或者树，数据存放在二维结构上，装载因子较大时也适合）
4. ### Hash 应用
- 安全加密 （不可逆性）
- 唯一标志，数字证书，数据校验（敏感性，稳定性）
- 散列函数，hash表 （敏感性，冲突概率小）
- 负载均衡（稳定性）
- 数据分片，分布式存储 （稳定性）
5. ### Hash表 设计
- 要求: 支持快速的增删改查，内存占用合理，稳定
- 设计参考因数：散列函数，散列冲突，初始容量，装载因子阀值，动态扩缩容策略，
## 二叉树
1. ### 二叉树结构
- 每个节点有两个叉，分别左子节点和右子节点
2. ### 二叉树类型
-  按照节点存储方式：链式存储的二叉树（节点通过指针关联），顺序存储的二叉树（数组，节点通过公式关联）
-  按照节点状态：满二叉树（所有节点均有左右子节点），完全二叉树（最后一层以外的所有节点均有左右子节点），普通二叉树
3. ### 遍历方式
- 前序遍历 根左右（根右左）
- 中序遍历 左根右（右根左），排序
- 后续遍历 左右根 (右左根)
- 遍历时间复杂度O(n),每个节点访问2次（一进一出），共访问2n次
- 递归遍历模版
```golang
/**
type ListNode struct {
    Val int
    Left,Right *ListNode
}
**/
// 必须包含 递归终止条件 递归左节点 递归右节点 处理当前节点

// 前序遍历模版
func preOrderTravel(root *ListNode) {
    // 递归终止条件
    if root == nil {
        return
    }
    // 处理当前节点
    print(node.Val)
    // 递归左节点
    preOrderTravel(root.Left)
    // 递归右节点
    preOrderTravel(root.Right)
}

// 中序遍历模版
func inOrderTravel(root *ListNode) {
    // 递归终止条件
    if root == nil {
        return
    }
    // 递归左节点
    inOrderTravel(root.Left)
    // 处理当前节点
    print(node.Val)
    // 递归右节点
    inOrderTravel(root.Right)
}

// 后序遍历模版
func postOrderTravel(root *ListNode) {
    // 递归终止条件
    if root == nil {
        return
    }
    // 递归左节点
    postOrderTravel(root.Left)
    // 递归右节点
    postOrderTravel(root.Right)
    // 处理当前节点
    print(node.Val)
}
```
4. ### 二叉树平衡算法
- 红黑树
- ALV
5. ### 二叉树应用
-  二叉搜索树
-  大小项堆
-  优先队列
## 递归
1. ### 递归特点
- 具有终止条件
- 可以分解为重复子问题，子问题之间存在迭代递推公式
- 子问题逻辑保持一致规模不同
2. ### 递归模版
```golang
   func recur(level int,params int) {
       // 终止条件
       if level > MAX_LEVEL {
           return
       }
       // 处理当前层级逻辑
       process(params)
       // 递归至下一层
       recur(level+1,params)
       // 清理当前层级状态
       clean(params)
   }
```
3. ### 递归注意因数
- 堆栈溢出（递归深度大可考虑迭代和自建堆栈）
- 重复计算（可以使用换缓存来记忆已计算的结果）
4. ### 递归与循环
- 递归需要借助栈来实现，会比循环多消耗一下资源，可能会出现堆栈溢出或者重复计算问题
- 递归相对循环往往是代码更凝练简洁和便于理解，代码实现往往比循环简单
- 尾递归优化可以减少常用栈空间的占用
5. ### 尾递归
- 原理：在递归的基础上，使用上一次调用返回状态作为新的状态作为下一次递归的状态参数，即存在F(x),F(n) = F(F(n-1)) 
- 本质是递归转换为循环，总的来说，一般没有什么特别大的用处
- 尾递归举例（斐波那次）
```golang
// 原始递归版
func fibUseRecur(n int) int {
	if n <= 2 {
		return n
	}
	return fibUseRecur(n-1) + fibUseRecur(n-2)
}

// 尾递归版本
func fibUseTailRecur(target,fv, sv int) int {
	if target <= 1 {
		return fv
	}
	if target == 2 {
		return sv
	}
	return fibUseTailRecur(target-1, sv, fv+sv)
}
// fibUseRecur(6) == fibUseTailRecur(6,1,2)
``` 


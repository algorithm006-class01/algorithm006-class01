# Week 5 Dynamic Programming
1. **善用数学归纳法**
寻找重复性 => 找到最近最简方法，拆解成可重复解决的问题
2. 避免人肉递归 => 画递归树

## DP: Divide & Conquer + optimal structure

动态规划 和 递归或者分治 没有根本上的区别 （关键看有无最优子结构）
共性：找到重复子问题
差异性：最优子结构、中途可以淘汰次优解
three steps:
1. 化繁为简 => 各种子问题
2. 定义好状态空间
3. 状态转移方程

## Fibonacci
use **recursion** -> from top to bottom
```python
def fibonacci(n,memo):
    if(n<=1): return n
    if(memo[n] ==0): memo[n] = fibonacci(n-1) + fibonacci(n-2)
    return memo[n]
```

Use **iteration** -> from bottom to top

## Count the path
paths(start, end) = path(A,end) + path(B,end)<br>
path(A,end) = path(D,end) + path(C,end)<br>
path(B,end) = path(C,end) + path(E,end)

状态转移方程
```python
opt[i,j] = opt[i+1,j] + opt[i,j+1]
```

完整逻辑
```python
if a[i.j] = ‘empty’:
	opt[i,j] = opt[i+1,j] + opt[i,j+1]
else: opt[i,j] = 0
```

Key points:
1. 最优子结构 opt[n] = best_of(opt[n-1],opt[n-2], ...)
2. 存储中间状态
3. 状态转移方程

## `Largest common sequence`
Brute fore: list combination subsets of the string in text1 and compare each of them with text2

DP: 找重复子问题
1. Text1 = “” text2 = 任意字符串 return “”
2. Text1 = “A” , text2 = 任意 return “A” if “A” in text2 else “”
3. Text1 = “.......A”, text2 = "...A” 从最后一个字符看起，因为最后一个字符是相同的，就是求”A”之前的最长子序列

Text1, text2 两个字符串排成一个矩阵的形式，比如
|   | A | B | A | Z | D | C |
|---|---|---|---|---|---|---|
| **B** |   |   |   |   |   |   |
| **A** |   |   |   |   |   |   |
| **C** |   |   |   |   |   |   |
| **B** |   |   |   |   |   |   |
| **A** |   |   |   |   |   |   |
| **D** |   |   |   |   |   |   |

If text1[-1] != text2[-1]: LCS[text1,text2] = MAX(LCS[text1-1,text2], LCS[text1,text2-1])<br>
Note it actually is LCS[text1,text2] = MAX(LCS[text1-1,text2], LCS[text1,text2-1],LCS[text1-1,text2-1])<br>
But the case LCS[text1-1,text2-1] will be considered in LCS[text1-1,text2]<br>

If text1[-1] = text2[-1]: LCS[text1,text2] = LCS[text1-1,text2-1] + 1<br>
Note it actually is LCS[text1,text2] = MAX(LCS[text1-1,text2], LCS[text1,text2-1],LCS[text1-1,text2-1],LCS[text1-1,text2-1] + 1)<br>
But it can be proved that LCS[text1-1,text2-1] + 1 is always the max.<br>

## 爬楼梯问题
如果相邻的两个步伐不能相同，思考如何去写状态方程 => 加多一个维度，参考后面的`house robber`

## 三角形最小路径和
1. brute force， 递归，n层：left or right: 2^n
2. DP
    从 2 走到下面的最小路径 即min(3走到下面的最小路径，4走到下面的最小路径)，往下递推
    * 重复性（分治） problem(i,j) = min(sub(i+1,j),sub(I+1,j+1)) + a[i,j]) i is layer, j is left or right node
    * 定义状态数组和状态转移方程  f[i,j]= min(f[i+1,j],f[i+1,j+1]) + a[i,j]

## 最大子序列和
1. Brute force: 列举起点和终点，n^2
2. DP：
    * 分治（子问题）从后面开始看，包括第i个index的数的最大和 max_sum(i) = MAX(max_sum(i-1),0) + a[i],max(max_sum(i-1),0) 指的是 subproblem 包括第i-1个index的数往前看的最大和，0即不包括第i-1个数=>最大子序和 = 当前元素自身最大，或者 包含之前后最大
    * 状态数组定义 f[i]
    * DP方程：f[i] = max(f[i-1],0) + a[i]

## Coin Change
有多少种不同的组合 = 上楼梯问题
1. brute force 递归 11-1 or 11-2 or 11-5 再往下递推 广度优先遍历求解
2. BFS
3. DP
    * subproblems
    * DP array f(n) = min(f(n-k) for k in [1,2,5]) + 1

## house robber
1
```python
# a[i]: 0,...,i能偷到的max value: a[n-1]
# 要加上房子有没有被偷的信息：a[i][0,1]: 0: i偷, 1:不偷
a[i][0] = max(a[i-1][0],a[i-1][1])
a[i][1] = a[i-1][0] + nums[i]
```

2
```python
# a[i]: 0,...,i能偷到的max value: max(a)
# a[i]:0,..,i天，且nums[i]必偷的最大值
a[i] = max(a[i-1],a[i-2] + nums[i]) i-1天偷了第i天就不能偷了
```
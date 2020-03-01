#### 分治
* 概念：将一个大问题拆解为若干个子问题，子问题得到结果时再以某种方式去合并结果集。从而得到最终的答案。
* 代码模版
    ```java
    public void divideConquer(Problem problem ,Param p1 ,Param p2 , ...){
        // recursion terminator
        if (porblem == null) {
            // print result;
            return;
        }   
        
        // prepare data
        Object data = prepare_data(problem)
        List<Problem> subproblems = splitProblem(problem, data)
        // conquer subproblems
        Object subresult1 = this.divideConquer(subproblems[0], p1, ...)
        Object subresult2 = this.divideConquer(subproblems[1], p1, ...)
        Object subresult3 = this.divideConquer(subproblems[2], p1, ...)
        // ...
        //  process and generate the final result
        Object result = processResult(subresult1, subresult2, subresult3, ...)
        // # revert the current level states
    }
    ```
* 分治回溯的递归状态树
    ```text
                      problem root
                    /              \ 
                root:p1           root:p2
                /    \            /     \
           p1:p3    p1:p4      p2:p5    p2:p6
             .        .          .        .
             .        .          .        .
             .        .          .        .
    ```
#### 回溯
回溯法采用试错的思想，它尝试分步去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步解答答案不能有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其他的可能的分步解答再次尝试寻找问题的答案。

回溯法尝试上述步骤后可能出现出现两种结果：
1. 找到可能存在的正确的答案。
2. 在尝试了所有的可能的分步方法后宣告该问题没有答案。

在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

#### 深度优先遍历（DFS），广度优先遍历（BFS）

* 二叉树定义模板
```java

public class TreeNode{
    public TreeNode left, right;
    public int val;
    
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;        
    }   
}
```

* N叉树定义模板
```java
import java.util.List;

public class Node {
    public int val;
    public List<Node> children;
    
    public Node(int val) {
        this.val = val;
    }   
}
```

* DFS 递归遍历模板
    ```java
    private Set<TreeNode> visited;
    
    // N叉树
    public void dfs(Node root, List<Node> traversalPath) {
        if (visited.contains(root)) {
            // already visited;
            return;
        }   
        visited.add(root);
        traversalPath.add(root);
        // process current node
        List<Node> children = root.children;
        if (children == null) {
            return;
        }
        
        for (Node node : children) {
            if (!visited.contains(node)) {
                dfs(node);
            }
        }   
    }   
    ```
* DFS 迭代遍历
```text
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
* BFS 遍历
```text
def BFS(graph, start, end):
    queue = []
    queue.append([start])
    visited.add(start)
    while queue:
      node = queue.pop()
      visited.add(node)
      process(node)
      nodes = generate_related_nodes(node)
      queue.push(nodes)
    ...
```
#### 贪心算法  
贪心算法是一种在每一步选择中都采取在当前状态下最好或最优(即最有利)的选择，从而希望导致结果是全局最好或最优的算法。

贪心法可以解决一些最优化问题，如:求图中的最小生成树、求哈夫曼编码等。然而对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案。

一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。

适用贪心算法的场景：简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。  
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

#### 二分查找
* 前提：
    1. 目标函数单调性(单调递增或者递减) 
    2. 存在上下界(bounded)
    3. 能够通过索引访问(index accessible)
* 模板：
```text
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
学习笔记

## 2020/3/17
* 搜索树
1. 节点不存储整个单词，只存储一个字母。全路径连一起才是词
2. 同一节点的所有子节点表示的字母都不同
3. 节点可以存储出现的频次（额外信息）


* A*
```
def AStarSearch(graph, start, end):
    pq = collections.priority_queue() #优先级->估价函数
    pq.append([start])
    visited.add(start)
    
    while pq:
        node = pq.pop()
        visited.add(node)
        
        process(node)
        nodes = generate_related_nodes(node)
        unvisited = [node for node in nodes if node not in visited]
        pq.push(unvisited)
```

1. 启发式函数（估价函数)
    * h(n)用来评估哪些节点是我们要找的最有希望的节点，会返回非负实数，可以认为是从节点n的目标节点路径的估计成本
    * 启发式函数是一种告知搜索方向的方法
    
* AVL树
1. 平衡二叉搜索树
2. 每个节点存平衡因子(-1,0,1) 左右子树高度差
3. 四种旋转(右旋，左旋，右左旋，左右旋)
4. 调整次数频繁

* 红黑树  O(logN)
1. 近似平衡二叉树，确保左右子树高度差小于两倍(减少旋转频率)
2. 每个节点要么是黑的，要么是红的
3. 根节点一定是黑的
4. 叶子结点，空节点一定是黑的
5. 不能有两个相邻的红节点
6. 从任一节点到其每个叶子节点的所有路径都包含相同数目的黑节点

读多用AVL，读一半写一半用红黑


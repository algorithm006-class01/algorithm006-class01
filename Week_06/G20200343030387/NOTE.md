学习笔记
## 知识点
1. 字典树
    a. 单词拆成字母节点存储
    b. 空间换时间的思想
    c. 适用前缀匹配场景，例如搜索栏的autocomplete；
2. 并查集
    a. 记住代码模板
    b. 应用场景：组团、配对问题，如朋友圈
2. 高级搜索
    a. 剪枝：递归时提前中断一些不必要的遍历；
    b. 双向搜索：前后同时向中间进行BFS；
    c. 启发式搜索(A*)：BFS + 优先队列 + 优先权重计算
    d. 深度学习，思想也是状态树的搜索，不过是中间的剪枝评估更高级了
3. 红黑树、AVL
    a. 了解AVL的四种旋转操作
    b. 两者的应用场景：红黑树适用插入、删除较多，AVL更适合读操作较多

## 并查集代码模板
* java

```java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```

* python
```python
def init(p): 
	# for i = 0 .. n: p[i] = i; 
	p = [i for i in range(n)] 
 
def union(self, p, i, j): 
	p1 = self.parent(p, i) 
	p2 = self.parent(p, j) 
	p[p1] = p2 
 
def parent(self, p, i): 
	root = i 
	while p[root] != root: 
		root = p[root] 
	while p[i] != i: # 路径压缩 ?
		x = i; i = p[i]; p[x] = root 
	return root
```

## 双向BFS代码模板
```
def BFS(graph, start, end):
    visited = set()
	front = set()
    back = set()
	front.add([start]) 
    back.add([end])

	while front: 
		visited.add(node)

        for node in front:
		    process(node)

		nodes = generate_related_nodes(node) 
		front = set(nodes)
        if len(front) > len(back):
            swap(front, back)

	# other processing work 
	...
```

## A*代码模板
```
def AstarSearch(graph, start, end):

	pq = collections.priority_queue() # 优先级 —> 估价函数
	pq.append([start]) 
	visited.add(start)

	while pq: 
		node = pq.pop() # can we add more intelligence here ?
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
   unvisited = [node for node in nodes if node not in visited]
		pq.push(unvisited)
```
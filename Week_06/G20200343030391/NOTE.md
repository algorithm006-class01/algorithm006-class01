# 学习笔记
## 字典树
### 基本结构
   - 字典树，即 Trie 树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。 它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。
### 基本性质
   - 1. 结点本身不存完整单词；
   - 2. 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串；
   - 3. 每个结点的所有子结点路径代表的字符都不相同。

### 核心思想
   - Trie 树的核心思想是空间换时间。利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。
## 并查集

### 适用场景
   - 组团、配对问题
   - Group or not ?
### 基本操作
   - makeSet(s)：建立一个新的并查集，其中包含 s 个单元素集合。
   - unionSet(x, y)：把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在
    的集合不相交，如果相交则不合并。
   - ind(x)：找到元素 x 所在的集合的代表，该操作也可以用于判断两个元
    素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。
### 代码模板
   ```java
        class UF {
                // 连通分量个数
                private int count;
                // 存储一棵树
                private int[] parent;
                // 记录树的“重量”
                private int[] size;
        
                public UF(int n) {
                    this.count = n;
                    parent = new int[n];
                    size = new int[n];
                    for (int i = 0; i < n; i++) {
                        parent[i] = i;
                        size[i] = 1;
                    }
                }
        
                public void union(int p, int q) {
                    int rootP = find(p);
                    int rootQ = find(q);
                    if (rootP == rootQ)
                        return;
        
                    // 小树接到大树下面，较平衡
                    if (size[rootP] > size[rootQ]) {
                        parent[rootQ] = rootP;
                        size[rootP] += size[rootQ];
                    } else {
                        parent[rootP] = rootQ;
                        size[rootQ] += size[rootP];
                    }
                    count--;
                }
        
                public boolean connected(int p, int q) {
                    int rootP = find(p);
                    int rootQ = find(q);
                    return rootP == rootQ;
                }
        
                private int find(int x) {
                    while (parent[x] != x) {
                        // 进行路径压缩
                        parent[x] = parent[parent[x]];
                        x = parent[x];
                    }
                    return x;
                }
        
                public int count() {
                    return count;
                }
            }
   ``` 
## A*
### 估价函数
   
### 代码模板
   ```java
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
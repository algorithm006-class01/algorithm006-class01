# 学习笔记
## 字典树
### 基本结构
    - 
### 基本性质
    - 

### 核心思想

## 并查集

### 适用场景

### 基本操作

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
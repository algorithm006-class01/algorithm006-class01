一、回溯算法

​	定义: 回溯算法用于在一棵隐式的树上进行搜索.做题的时候需要现在纸上画出“递归树”,进而打开思路然后才是编码

1. 在隐式树上的深度优先遍历

   a . 状态转换

   b. 使用深度优先遍历,直接使用系统栈保存节点信息,编码简单

   c. 深度优先遍历更符合人们做事情“一条道走到底”的态度

   d. 如果使用广度优先遍历,得自己编写节点类和使用队列

2. 理解回溯

   a. 从深层节点回到浅层节点必须“回到过去”

   b. 回溯可以理解“状态重置”,“回到过去”,“恢复现场”
   c. 状态空间很大的时候,我们可能只需要其中的某些状态(一般都是叶子节点),因此全局使用一份状态即可

   d. 在每一个节点都适用新的状态变量的时候不必回溯

3. 善用剪纸,提前结束搜索

   a. 提前知道此路不通的时候,就“拐弯”,这一步操作称为“剪枝”

   b. 搜索算法状态庞大,剪枝是必须要的

二、贪心算法

三、分治算法

四、代码模板总结

1. 递归代码模版

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

2. 分治代码模板

   ```python
   def divide_conquer(problem, param1, param2, ...): 
     # recursion terminator 
     if problem is None: 
   	print_result 
   	return 
   
     # prepare data 
     data = prepare_data(problem) 
     subproblems = split_problem(problem, data) 
   
     # conquer subproblems 
     subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
     subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
     subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
     …
   
     # process and generate the final result 
     result = process_result(subresult1, subresult2, subresult3, …)
   	
     # revert the current level states
   ```

3. 深度优先代码模板DFS

   a. 递归方式

   ```python
   def divide_conquer(problem, param1, param2, ...): 
     # recursion terminator 
     if problem is None: 
   	print_result 
   	return 
   
     # prepare data 
     data = prepare_data(problem) 
     subproblems = split_problem(problem, data) 
   
     # conquer subproblems 
     subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
     subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
     subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
     …
   
     # process and generate the final result 
     result = process_result(subresult1, subresult2, subresult3, …)
   	
     # revert the current level states
   ```

   b. 非递归方式

   ```python
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

   

4. 广度优先代码模板BFS

   ```python
   def BFS(graph, start, end):
       visited = set()
   	queue = [] 
   	queue.append([start]) 
   
   	while queue: 
   		node = queue.pop() 
   		visited.add(node)
   
   		process(node) 
   		nodes = generate_related_nodes(node) 
   		queue.push(nodes)
   
   	# other processing work 
   	...
   ```

5. 二分查找代码模板

   ```java
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

   
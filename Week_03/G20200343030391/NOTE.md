学习笔记
# 分治
   - 代码模板
       ```java
          public void divide_cpnquer(int lever,int[] param) {
            // terminator
            if(leverl > max_level){
                // process result
                return;
            }
            // prepare data
            int num1=prepare_data(parm)
            // divide
            int []sub_problems = split_problem(param,num1)
            // cpnquer subproblems
            
            int sub_result1 = diver_conquer(sub_problems[0]);
            int sub_result2 = diver_conquer(sub_problems[1]);
            int sub_result3 = diver_conquer(sub_problems[2]);
            
            //process and generate the final result
            result = process_result(sub_result1,sub_result2,sub_result3)
            
            //restore current status
          }
       ``` 
# 回溯ddd   
   - 模板
        ```java
            int a=0;
        ```
# 深度优先
   - 模板
     - 递归写法
       ```java
          public void dfs(visited,node){
             //terminator
             if (visited.contains(node)) {
                 return;
             }       
             visited.add(node);
             //process current node here
             for(Node child : node.children()){
                  if (!visited.contains(child)) {
                      dfs(visited,child)
                  }   
             }       
         }
       ```
     - 循环写法
        ```java
           public void dfs(node){
              if(node==null){
                  return;
              }    
              Stack stack = new Stack();
              stack.push(node);
              while(!stack.isEmpty){
                   node = stack.pop();
                   process(node);
                   nodes = generate_related_node(node);
                   stack.push(nodes)
              }   
          }
        ```
         
# 广度优先
   - 模板
       ```java
         public void bfs(node){
             Set<Node> visited = new HashSet();
             Deque queue = new Deque(); 
             queue.push([start]); 
             while (!queue.isEmpty()){
                 node = queue.pop() 
                 visited.add(node)
            
                 process(node) 
                 nodes = generate_related_nodes(node) 
                 queue.push(nodes)
             }
            # other processing work 
            ...   
         }
       ```
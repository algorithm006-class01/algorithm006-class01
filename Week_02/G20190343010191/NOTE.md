### 学习笔记
这次主要练习递归

树的走访的前中后序

#### 树走访代码模版：


    def preorder(self,root):
        if root:
            self.traverse_path.append(root.val)
            self.preorder(root.left)
            self.preorder(root.right) 
    
    def inorder(self,root):
        if root:        
            self.preorder(root.left)
            self.traverse_path.append(root.val)
            self.preorder(root.right) 
    
    def postorder(self,root):
        if root:        
            self.preorder(root.left)
            self.preorder(root.right) 
            self.traverse_path.append(root.val)

递归代码模版

    def recursion(level,param1,param2,...)
        #terminator
        #先写终止条件
        
        if level > MAX_LEVEL:
            #process result
            return
        #逻辑处理 
        process(level,data)
        
        #drill　down
        self.recursion(level+1,p1,p2,...)
        
        # 清理当前层状态( 如果需要)
        

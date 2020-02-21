学习笔记
#### 树形结构
* 二叉树结点定义
    ```java
    public class TreeNode {
        public int value;
        public TreeNode left,right;
        
        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }   
    }
    ```
* 二叉树结构的前中后序遍历
    ```java
    import java.util.List;
    
    public class General {
        private List<Integer> traversePath;
        
        public void preorder(TreeNode root){
            if (root != null) {
                this.traversePath.add(root.value);
                this.preorder(root.left);
                this.preorder(root.right);
            }
        }    
        
        public void inorder(TreeNode root) {
            if (root != null) {
                this.inorder(root.left);
                this.traversePath.add(root.value);
                this.inorder(root.right);
            }
        }
        
        public void postorder(TreeNode root) {
            if (root != null) {
                this.postorder(root.left);
                this.postorder(root.right);
                this.traversePath.add(root.value);
            }
        }   
    }
    ```
* 树形结构的时间复杂度为 O(log n)
* 二叉搜索树的中序遍历是递增的
#### 泛型递归
* 代码模版
    ```java
    public void recursion(int level, int param){
        // recursion terminal
        if (level > MAX_LEVEL) {
            // process result
            return;
        }   
        // process current logic
        process(level, param);
        
        // drill down
        recursion(level, level + 1, param);
        
        // restore current status
    }
    ```
* 思维要点  
    1. 拒绝人肉进行递归（最大误区）
    2. 找到最近最简方法，将其拆解为可重复解决的问题（重复子问题）
    3. 数学归纳法思维

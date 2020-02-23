学习笔记

# 本周学习主要算法模型代码

#

#  树的遍历
# 前序遍历模型
def preorder_tree(root):
    if root:
        self.tree_nodes.append(root)
        self.preorder_tree(root.left)
        self.preorder_tree(root.right)

# 中序遍历模型
def inorder_tree(root):
    if root:

        self.inorcer_tree(root.left)
        self.tree_nodes.append(root)
        self.inorder_tree(root.right)

# 后序遍历模型
def post_tree(root):
    if root:

        self.postorder_tree(root.left)
        self.postorcer_tree(root.right)
        self.tree_nodes.append(root)



# 递归模版代码
def recursion(level,param1,param2,...):
    # recursion terminator
    # 递归终止条件
    if level > MAX_LEVEL:
        process_result
        return

    # process logic in current level
    # 本层的程序逻辑代码
    process(level,data,...)

    # drill down
    # 进入下一次
    self.recursion(level+1,p1,...)

    # reserve the current level status if needed
    # 本层收尾代码


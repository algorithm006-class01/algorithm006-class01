# 二叉树前序遍历
def preorder_tree(root):
    res = []
    p = root
    stack = []
    while p or stack:
        while p:
            res.append(p.val)
            stack.append(p)
            p = p.left
        p = stack.pop().right
    return res
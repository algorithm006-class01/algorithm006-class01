# 迭代：通过更新变量的值层层推进到所要的答案

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

#前序
def preorderTraversal(root: TreeNode):
    if not root:
        return []
    res = []
    stack = [root]
    while stack:
        node = stack.pop()  # python列表，移出最后一个元素，所以符合栈的特性
        res.append(node.val)
        if node.right:
            stack.append(node.right)
        if node.left:
            stack.append(node.left)
    return res
#中序
def inorderTraversal(root: TreeNode):
    if not root:
        return []
    res = []
    stack = []
    cur = root
    while cur or stack:
        while cur:
            stack.append(cur)
            cur = cur.left
        cur = stack.pop()
        res.append(cur.val)
        cur = cur.right
    return res

#后续
def postorderTraversal(root: TreeNode):
    if not root:
        return []
    res = []
    stack = [root]
    while stack:
        node = stack.pop()  # python列表，移出最后一个元素，所以符合栈的特性
        if node.left:
            stack.append(node.left)
        if node.right:
            stack.append(node.right)
        res.append(node.val)
    return res[::-1]

def levelOrder( root):
    if not root:
        return []

    res, cur_level = [], [root]
    while cur_level:
        temp = []
        next_level = []
        for i in cur_level:
            temp.append(i.val)

            if i.left:
                next_level.append(i.left)
            if i.right:
                next_level.append(i.right)
        res.append(temp)
        cur_level = next_level
    return res

# 从数组构建树--这里是按层级
def buildtree(nodes, treevals):
    print(treevals)
    if len(treevals) == 0:
        return
    temp = []
    for node in nodes:

        if len(treevals) == 1:
            node.left = TreeNode(treevals[0])
            temp.append(node.left)
            treevals = []
            print(node.val, ":", node.left.val)
            break
        if len(treevals) == 2:
            node.left = TreeNode(treevals[0])
            temp.append(node.left)
            node.right = TreeNode(treevals[1])
            temp.append(node.right)
            treevals = []
            print(node.val, ":", node.left.val, node.right.val)
            break
        if len(treevals) > 2:
            node.left = TreeNode(treevals[0])
            temp.append(node.left)
            node.right = TreeNode(treevals[1])
            temp.append(node.right)
            treevals = treevals[2:]
            print(node.val, ":", node.left.val, node.right.val)

    buildtree(temp, treevals)

l = [3, 5, 1, 6, 2, 0, 8, None, None, 7, 4]

if len(l):
    r = TreeNode(l[0])
    buildtree([r], l[1:])
    print("前序：", preorderTraversal(r))
    print("中序：", inorderTraversal(r))
    print("后序：", postorderTraversal(r))
    print("广度优先：", levelOrder(r))

# 前序： [3, 5, 6, None, None, 2, 7, 4, 1, 0, 8]
# 中序： [None, 6, None, 5, 7, 2, 4, 3, 0, 1, 8]
# 后序： [None, None, 6, 7, 4, 2, 5, 0, 8, 1, 3]
# 广度优先： [[3], [5, 1], [6, 2, 0, 8], [None, None, 7, 4]]
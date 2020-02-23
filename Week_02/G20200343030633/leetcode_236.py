# 递归出两个指定数的到根节点的路径；然后在两个路径中寻找交叉点；最靠后的那个交叉点既是

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def buildlist(root: TreeNode, v: int):
    result = []
    if v == root.val:  # 如果当前节点是指定节点则终结，同时将其本身加入路径中
        result.append(root.val)
    else:
        if root.left:
            l1 = buildlist(root.left, v)  # 下探
            if v in l1:  # 如果列表中存在指定数值则将此节点加入、否则忽略
                result.append(root.val)
                result += l1
        if root.right:
            l2 = buildlist(root.right, v)
            if v in l2:
                result.append(root.val)
                result += l2
    return result


def isinlist(v, l):
    for i in l:
        if v == i:
            return True
    return False


def lowestCommonAncestor(root, p, q):
    listp = buildlist(root, p)
    listq = buildlist(root, q)
    print(p, ":", listp)
    print(q, ":", listq)
    result = []
    for x in listp:
        for y in listq:
            if x == y:
                result.append(x)
    if len(result) > 0:
        return result[len(result) - 1]
    return root.val


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


# 按层级打印
def levelprint(nodes: list):
    if len(nodes) == 0:
        return
    temp = []
    for node in nodes:
        print(node.val)
        if node.left:
            temp.append(node.left)
        if node.right:
            temp.append(node.right)
    levelprint(temp)


l = [3, 5, 1, 6, 2, 0, 8, None, None, 7, 4]

if len(l):
    r = TreeNode(l[0])
    buildtree([r], l[1:])
    print("################################")
    levelprint([r])

    print("答案是：", lowestCommonAncestor(r, 5, 4))

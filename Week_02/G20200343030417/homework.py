
# 49，字母异位词分组
strs = ["eat", "tea", "tan", "ate", "nat", "bat"]

def groupAnagrams(strs):
    dic = {}
    for i in strs:
        a = sorted(i)
        # print('-----',a)
        b = tuple(a)
        print(b)
        if b not in dic:
            dic[b] = [i]
        else:
            dic[b].append(i)

    m = [i for i in dic.values()]
    return m

# groupAnagrams(strs)

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
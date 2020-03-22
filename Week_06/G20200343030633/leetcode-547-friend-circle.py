# 并查集查找孤岛


def union(p, i, j):
    p1 = parent(p, i)
    p2 = parent(p, j)
    p[p1] = p2


def parent(p, i):
    root = i
    while p[root] != root:
        root = p[root]

    while p[i] != i:  # 路径压缩
        x = i
        i = p[i]
        p[x] = root

    return root


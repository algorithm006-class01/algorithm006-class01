"""
    班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
    如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

    给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
    如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

    示例 1:
        输入:
        [[1,1,0],
         [1,1,0],
         [0,0,1]]
        输出: 2
        说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
        第2个学生自己在一个朋友圈。所以返回2。

    示例 2:
        输入:
        [[1,1,0],
         [1,1,1],
         [0,1,1]]
        输出: 1
        说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
        注意：

    N 在[1,200]的范围内。
    对于所有学生，有M[i][i] = 1。
    如果有M[i][j] = 1，则有M[j][i] = 1。
"""

from typing import List


class Solution:
    DIRECTION = ((1, 0), (-1, 0), (0, 1), (0, -1))

    def findCircleNum(self, M: List[List[int]]) -> int:
        return self.dis_join_set(M)

    @classmethod
    def dis_join_set(cls, M: List[List[int]]) -> int:
        def union(p, i1, i2):
            r1 = find(p, i1)
            r2 = find(p, i2)
            p[r1] = r2

        def find(p, i):
            root = i

            while p[root] != root:
                root = p[root]

            while p[i] != i:
                x = i
                i = p[i]
                p[x] = root
            return root

        p_list = [i for i in range(len(M))]
        for i in range(len(M)):
            for j in range(len(M[0])):
                if M[i][j] == 1:
                    union(p_list, i, j)
        return len(set([find(p_list, i) for i in range(len(M))]))

    @classmethod
    def dfs(cls, M: List[List[int]]) -> int:
        """
            时间复杂度：O(n**2)
            空间复杂度：O(n)
        """
        if not M:
            return 0
        m = len(M)
        visited = [False] * m

        def dfs(u):
            for j in range(m):
                if M[u][j] == 1 and visited[j] is False:
                    visited[j] = True
                    dfs(j)

        count = 0
        for i in range(m):
            if visited[i] is False:
                count += 1
                visited[i] = True
                dfs(i)
        return count

    @classmethod
    def bfs(cls, M: List[List[int]]) -> int:
        pass


if __name__ == '__main__':
    print(Solution().findCircleNum(
        [
            [1, 0, 0, 1],
            [0, 1, 1, 0],
            [0, 1, 1, 1],
            [1, 0, 1, 1]
        ]
    ))

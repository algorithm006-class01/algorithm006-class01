/*
 * @lc app=leetcode.cn id=547 lang=swift
 *
 * [547] 朋友圈
 *
 * https://leetcode-cn.com/problems/friend-circles/description/
 *
 * algorithms
 * Medium (54.73%)
 * Likes:    198
 * Dislikes: 0
 * Total Accepted:    30K
 * Total Submissions: 54K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是
 * C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j
 * 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 
 * [[1,1,0],
 * ⁠[1,1,0],
 * ⁠[0,0,1]]
 * 输出: 2 
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 
 * [[1,1,0],
 * ⁠[1,1,1],
 * ⁠[0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 
 * 
 * 注意：
 * 
 * 
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 * 
 * 
 */

// @lc code=start
class Solution {
    func findCircleNum(_ M: [[Int]]) -> Int {
        let unionFind = UnionFind(n: M.count)
        for i in 0..<M.count {
            for j in 0..<M.count {
                if M[i][j] == 1 && unionFind.find(i) != unionFind.find(j) {
                    unionFind.union(i, j)
                }
            }
        }
        return unionFind.count
    }
}

class UnionFind {
    var p: [Int]
    var count: Int
    init(n: Int) {
        p = []
        for i in 0..<n {
            p.append(i)
        }
        count = n
    }

    func union(_ i: Int, _ j: Int) {
        let rootI = find(i)
        let rootJ = find(j)
        if rootI != rootJ {
            p[rootI] = rootJ
            count -= 1
        }
    }

    func find(_ i: Int) -> Int {
        var root = i
        while root != p[root] {
            root = p[root]
        }
        // 路径压缩
        var i = i
        while i != p[i] {
            let x = i
            p[x] = root
            i = p[i]
        }
        return root
    }
}

// @lc code=end


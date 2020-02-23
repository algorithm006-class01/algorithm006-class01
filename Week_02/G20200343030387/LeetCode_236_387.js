/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
// 递归
// 深度递归左右子树节点，找到p,q并返回节点；
// 最外层顶点得到的情况就只有三种：在左或右子树上，或者在根节点上；
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor1 = function (root, p, q) {
    const helper = function (root, p, q) {
        if (!root) return null
        if (root.val === p.val || root.val === q.val) return root
        const left = helper(root.left, p, q)
        const right = helper(root.right, p, q)
        if (left && right) {
            // p, q在root的左右子节点上
            return root
        } else if (left) {
            return left
        } else if (right) {
            return right
        }
        return null
    }
    return helper(root, p, q)
};

// 父指针
// 找出p和q的所有父节点指针parents；
// 再其中分离出p的所有父节点parentsSetOfP；
// q根据parents逐层向上遍历父节点，最先落在parentsSetOfP上的父节点就是要求的节点
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function (root, p, q) {
    if (!root) return null
    const helper = function (root, parents) {
        if (root) {
            if (root.left) {
                parents[root.left.val] = root
                helper(root.left, parents)
            }
            if (root.right) {
                parents[root.right.val] = root
                helper(root.right, parents)
            }
        }
    }
    const parents = {}
    helper(root, parents)
    // 找出p的所有父节点
    const parentsSetOfP = []
    while (p) {
        parentsSetOfP.push(p.val)
        p = parents[p.val]
    }
    if (!parentsSetOfP.length) return null
    // 判断q的父节点是否在p的所有父节点中
    while (q) {
        if (parentsSetOfP.includes(q.val)) {
            return q
        }
        q = parents[q.val]
    }
    return null
}
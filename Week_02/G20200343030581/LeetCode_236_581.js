/*
 * @lc app=leetcode.cn id=236 lang=javascript
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
// 1.递归
var lowestCommonAncestor = function(root, p, q) {
    let res;
    function helper(root) {
        if (!root)
            return false;
        let mid = root == p || root == q;
        let l = helper(root.left, p, q);
        let r = helper(root.right, p, q);
        if (l + r + mid >= 2) {
            res = root;
            return true;
        }

        return mid || l || r;
    }
    helper(root);
    return res;
};

// 2.迭代
var lowestCommonAncestor = function(root, p, q) {
    let map = new Map();
    let stack = [root];
    map.set(root, null);
    while (!map.has(p) || !map.has(q)) {
        let tmp = stack.pop();
        if (tmp.right) {
            stack.push(tmp.right);
            map.set(tmp.right, tmp);
        }
        if (tmp.left) {
            stack.push(tmp.left);
            map.set(tmp.left, tmp);
        }
    }

    let set = new Set();
    while (p) {
        set.add(p);
        p = map.get(p);
    }

    while (!set.has(q)) {
        q = map.get(q);
    }

    return q;
}
// @lc code=end



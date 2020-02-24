/*
 * @lc app=leetcode.cn id=144 lang=javascript
 *
 * [144] 二叉树的前序遍历
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
 * @return {number[]}
 */
// 1.递归 O(n)
var preorderTraversal = function(root) {
    let res = [];
    function helper(root) {
        if (root) {
            res.push(root.val);
            helper(root.left);
            helper(root.right);
        }
    }

    helper(root);
    return res;
};

// 2.迭代 O(n)
var preorderTraversal = function(root) {
    let res = [];
    if (!root)
        return res;
    let stack = [root];
    while (stack.length) {
        let tmp = stack.pop();
        res.push(tmp.val);
        if (tmp.right)
            stack.push(tmp.right);
        if (tmp.left)
            stack.push(tmp.left);
    }

    return res;
}
// @lc code=end



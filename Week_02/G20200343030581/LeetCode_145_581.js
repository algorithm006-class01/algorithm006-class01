/*
 * @lc app=leetcode.cn id=145 lang=javascript
 *
 * [145] 二叉树的后序遍历
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
var postorderTraversal = function(root) {
    let res = [];
    function helper(root) {
        if (root) {
            helper(root.left);
            helper(root.right);
            res.push(root.val);
        }
    }

    helper(root);
    return res;
};

// 2.迭代 O(n)
var postorderTraversal = function(root) {
    let res = [];
    if (!root)
        return res;
    let stack = [root];
    while (stack.length) {
        let tmp = stack.pop();
        res.push(tmp.val);
        if (tmp.left)
            stack.push(tmp.left);
        if (tmp.right)
            stack.push(tmp.right);
    }

    return res.reverse();
}

// @lc code=end



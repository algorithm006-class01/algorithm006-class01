/*
 * @lc app=leetcode.cn id=94 lang=javascript
 *
 * [94] 二叉树的中序遍历
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
var inorderTraversal = function(root) {
    let res = [];
    function helper(root) {
        if (root) {
            helper(root.left);
            res.push(root.val);
            helper(root.right);
        }
    }

    helper(root);
    return res;
};

// 2.用栈去迭代 O(n) O(n)
var inorderTraversal = function(root) {
    let res = [];
    let stack = [];
    let cur = root;
    while (cur || stack.length) {
        while (cur) {
            stack.push(cur);
            cur = cur.left;
        }

        cur = stack.pop();
        res.push(cur.val);
        cur = cur.right;
    }

    return res;
}

var inorderTraversal = function(root) {
    let res = [];
    let stack = [];
    let cur = root;
    while (cur || stack.length) {
        if (cur) {
            stack.push(cur);
            cur = cur.left;
        } else {
            cur = stack.pop();
            res.push(cur.val);
            cur = cur.right;
        }
    }

    return res;
}

// 3. 莫里斯遍历 O(n) O(1)
var inorderTraversal = function (root) {
    let res = [];
    let cur = root;
    while (cur) {
        if (!cur.left) {
            res.push(cur.val);
            cur = cur.right;
        } else {
            let L = cur.left;
            while (L.right) {
                L = L.right;
            }
            L.right = cur;
            let tmp = cur;
            cur = cur.left;
            tmp.left = null;
        }
    }
    return res;
}
// @lc code=end



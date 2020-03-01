/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
// 1.递归
var postorder = function(root) {
    let res = [];
    function helper(root) {
        if (root) {
            if (root.children) {
                for (let child of root.children)
                    helper(child);
            }

            res.push(root.val);
        }
    }

    helper(root);
    return res;
};

// 2.非递归
var postorder = function(root) {
    let res = [];
    if (!root)
        return res;
    let stack = [root];
    while (stack.length) {
        let tmp = stack.pop();
        res.push(tmp.val);
        if (tmp.children) {
            for (let child of tmp.children)
                stack.push(child);
        }
    }

    return res.reverse();
}
// @lc code=end



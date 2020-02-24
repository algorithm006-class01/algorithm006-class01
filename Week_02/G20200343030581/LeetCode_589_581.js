/*
 * @lc app=leetcode.cn id=589 lang=javascript
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
// 1.递归
var preorder = function(root) {
    let res = [];
    function helper(root) {
        if (root) {
            res.push(root.val);
            if (root.children) {
                for (let child of root.children)
                    helper(child);
            }
        }
    }
    helper(root);
    return res;
};

// 1.迭代
var preorder = function(root) {
    let res = [];
    if (!root)
        return res;
    let stack = [root];
    while (stack.length) {
        let tmp = stack.pop();
        res.push(tmp.val);
        if (tmp.children) {
            let children = tmp.children;
            for (let i = children.length - 1; i >= 0; --i)
                stack.push(children[i]);
        }
    }
    return res;
}
// @lc code=end



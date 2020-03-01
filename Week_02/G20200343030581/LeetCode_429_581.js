/*
 * @lc app=leetcode.cn id=429 lang=javascript
 *
 * [429] N叉树的层序遍历
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
 * @return {number[][]}
 */
// 1.递归 先序遍历，记录层级
var levelOrder = function(root) {
    let res = [];
    function helper(level, root) {
        if (root) {
            let l;
            if (!(l = res[level]))
                res[level] = l = [];
            l.push(root.val);
            if (root.children) {
                for (let child of root.children) {
                    helper(level + 1, child);
                }
            }
        }
    }
    helper(0, root);
    return res;
};

// 2.BFS
var levelOrder = function(root) {
    let res = [];
    if (!root)
        return res;
    let queue = [root];
    while (queue.length) {
        let la = [];
        for (let i = 0, l = queue.length; i < l; i++) {
            let tmp = queue.shift();
            la.push(tmp.val);
            if (tmp.children) {
                for (let child of tmp.children)
                    queue.push(child);
            }
        }
        res.push(la);
    }
    return res;
}
// @lc code=end



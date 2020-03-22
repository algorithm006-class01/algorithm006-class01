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
var postorder = function (root) {
  //递归
  if (!root) return [];

  let res = [];
  recusion(root);
  return res;

  function recusion(root) {
    if (!root) return null;

    for (let i = 0; i < root.children.length; i++) {
      recusion(root.children[i]);
    }
    res.push(root.val)
  }
};
// @lc code=end

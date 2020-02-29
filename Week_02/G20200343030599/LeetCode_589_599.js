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
var preorder = function (root) {
  //递归
  if (!root) return [];

  let res = [];
  recusion(root);
  return res;

  function recusion(root) {
    if (!root) return null;

    res.push(root.val);
    for (let i = 0; i < root.children.length; i++) {
      recusion(root.children[i]);
    }
  }
};
// @lc code=end

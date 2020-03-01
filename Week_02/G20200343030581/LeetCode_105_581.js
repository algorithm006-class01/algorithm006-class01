/*
 * @lc app=leetcode.cn id=105 lang=javascript
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
    let p = 0;
    let inorderDic = {}
    for (let i = 0; i < inorder.length; i++) {
        inorderDic[inorder[i]] = i;
    }
    function helper(s, e) {
        if (s >= e)
            return null;
        let val = preorder[p++];
        let node = new TreeNode(val);
        let index = inorderDic[val];
        node.left = helper(s, index);
        node.right = helper(index + 1, e);
        return node;
    }

    return helper(0, inorder.length);
};
// @lc code=end



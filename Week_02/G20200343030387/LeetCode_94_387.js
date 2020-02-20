/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {Array} res
 * @return {undefined}
 */
const helper = function (root, res) {
    if (root !== null) {
        helper(root.left, res)
        res.push(root.val)
        helper(root.right, res)
    }
}
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function (root) {
    const res = []
    helper(root, res)
    return res
}
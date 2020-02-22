/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @params {number[]}
 * @return {undefined}
 */
// 系统栈
const helper = function (root, res) {
    if (root) {
        res.push(root.val)
        helper(root.left, res)
        helper(root.right, res)
    }
}
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal1 = function (root) {
    const res = []
    helper(root, res)
    return res
};

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
// 自定义栈
var preorderTraversal = function (root) {
    const res = []
    const stack = []
    let current = root
    stack.push(current)
    while (stack.length) {
        current = stack.pop()
        if (current) {
            res.push(current.val)
            if (current.right) {
                stack.push(current.right)
            }
            if (current.left) {
                stack.push(current.left)
            }
        }
    }
    return res
}
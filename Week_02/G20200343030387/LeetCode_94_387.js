/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
// 方法1：系统栈
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
const helper1 = function (root, res) {
    if (root !== null) {
        // 中序遍历：左根右（根在中间，所以称中序）
        helper(root.left, res)
        res.push(root.val)
        helper(root.right, res)
    }
}
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal1 = function (root) {
    const res = []
    helper(root, res)
    return res
}


/* ====================================================================== */

/**
 * 方法2：自定义栈
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function (root) {
    const res = []
    const stack = [] // 自定义的栈空间
    let current = root
    while (current || stack.length) {
        while (current) {
            stack.push(current) // 需要将结点push入栈，而不是结点的值
            current = current.left
        }
        current = stack.pop() // pop出结点，从该结点继续开始遍历
        res.push(current.val)
        current = current.right
    }
    return res
}
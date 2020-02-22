/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
// 系统栈递归
const helper = function (root, res) {
    if (root) {
        if (root.children) {
            for (let i = 0; i < root.children.length; i++) {
                helper(root.children[i], res)
            }
        }
        res.push(root.val)
    }
}
/**
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function (root) {
    const res = []
    helper(root, res)
    return res
};
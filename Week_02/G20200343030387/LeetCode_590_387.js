/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
// 系统栈递归
// 后序遍历：先遍历完该节点的子树节点，再添加上根
/**
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function (root) {
    const helper = function (root, res) {
        if (root) {
            if (root.children) {
                // 递归该子节点的所有子树节点
                root.children.forEach(child => {
                    helper(child, res)
                })
            }
            // 添加上根节点
            res.push(root.val)
        }
    }
    const res = []
    helper(root, res)
    return res
};
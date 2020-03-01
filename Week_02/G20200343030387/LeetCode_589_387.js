/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
// 系统栈
/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder1 = function (root) {
    const helper = function (root, res) {
        if (root) {
            res.push(root.val)
            root.children.forEach(item => {
                helper(item, res)
            })
        }
        return res
    }
    const res = []
    helper(root, res)
    return res
};

// 自定义栈
var preorder = function (root) {
    const stack = []
    const res = []
    let current = root
    stack.push(current)
    while (stack.length) {
        current = stack.pop()
        if (current) {
            res.push(current.val)
            if (current.children) {
                // 栈先入后出，所以要reverse
                current.children.reverse().forEach(child => {
                    stack.push(child)
                })
            }
        }
    }
    return res
}
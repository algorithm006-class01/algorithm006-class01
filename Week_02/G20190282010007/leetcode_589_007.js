// 题目: N叉树的前序遍历
/**
 * 题目描述：
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */

 // 解题语言: javaScript

 // 解题

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
var preorder = function(root) {
    // 如果一开始就是空，那就直接返回空
    if (!root) {return []}

    // 数据逻辑处理
    let res = []
    recusion(root)
    return res

    // 递归的方法
    function recusion(root) {
        // 终止条件
        if (!root) return
        // 处理操作
        res.push(root.val)
        // 进行下一层的递归
        for (let i = 0; i < root.children.length; i++) {
            recusion(root.children[i])
        }
    }
};
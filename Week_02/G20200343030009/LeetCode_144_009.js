/*
  给定一个二叉树，返回它的 前序 遍历。
   示例:
  输入: [1,null,2,3]  
    1
      \
      2
      /
    3 
  输出: [1,2,3]
  进阶: 递归算法很简单，你可以通过迭代算法完成吗？
*/
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function(root) {
  // 方法1：迭代法
  /*
    从根节点开始，每次迭代弹出当前栈顶元素，并将其孩子节点压入栈中，先压右孩子再压左孩子。
    在这个算法中，输出到最终结果的顺序按照 Top->Bottom 和 Left->Right，符合前序遍历的顺序
  */
  let stack = []
  let output = []
  if (root === null) return output
  // 推入根节点
  stack.push(root)
  while (stack.length) {
      // 弹出栈顶元素, 并推入output
      let node = stack.pop()
      output.push(node.val)
      // 先考察弹出的元素是否有右节点，再考察是否有左节点，先推右节点后推左节点，
      // 保证推入后，左节点在右节点上面，保证先弹出左节点，后弹出右节点--故为前序遍历
      if (node.right !== null) {
          // 有右节点，推入
          stack.push(node.right)
      }
      if (node.left !== null) {
          // 有左节点，推入
          stack.push(node.left)
      }
  }
  return output
};
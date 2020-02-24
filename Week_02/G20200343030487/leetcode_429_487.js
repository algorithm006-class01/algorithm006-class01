/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  if (!root) return []
  let queue = []
  const result = []
  queue.unshift(root)
  while (queue.length) {   
    const arr = []
    const newArr = []
    queue.forEach(item => {
      arr.push(item.val)
      item.children.forEach(child => child && newArr.push(child))
    })
    result.push(arr)
    queue = newArr.slice()
  }
  return result
}
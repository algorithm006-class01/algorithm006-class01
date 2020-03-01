// 递归法
var preorder1 = function(root) {
  var list = [];
  return preOrderNTree(root, list)
};

function preOrderNTree(root, list){
  if (!root) {
    return list
  }
  list.push(root.val)
  for (let i = 0, len = root.children.length; i < len; i++) {
    preOrderNTree(root.children[i], list)
  }
  return list
}

var preorder2 = function(root) {
  let stack = []
  const result = []
  if (!root) return result
  stack.push(root)
  while (stack.length) {
    const node = stack.pop()
    result.push(node.val)
    if (node.children) {
      node.children.reverse().map((item) => {
        stack.push(item)
      })
    }
  }
  return result
}
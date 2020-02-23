// 递归法
var postorder1 = function(root) {
  var list = [];
  return preOrderNTree(root, list)
};

function preOrderNTree(root, list){
  if (!root) {
    return list
  }
  for (let i = 0, len = root.children.length; i < len; i++) {
    preOrderNTree(root.children[i], list)
  }
  list.push(root.val)
  return list
}

var postorder2 = function(root) {
  let stack = []
  const result = []
  if (!root) return result
  stack.push(root)
  while (stack.length) {
    const node = stack.pop()
    result.push(node.val)
    if (node.children) {
      node.children.map((item) => {
        stack.push(item)
      })
    }
  }
  return result.reverse()
}
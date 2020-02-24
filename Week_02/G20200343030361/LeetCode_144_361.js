// iteration
// var preorderTraversal = function(root) {
//   if (!root) return []
//   let stack = [root];
//   let res = [];
//   let curr;

//   while (stack.length > 0) {
//     curr = stack.pop();
//     res.push(curr.val)

//     if (curr.right) stack.push(curr.right);
//     if (curr.left) stack.push(curr.left);
//   }

//   return res;
// };

// recursive
const preorderTraversal = root => {
  let res = [];
  helper(root, res);
  return res;
};

const helper = (root, res) => {
  if (!root) return;
  res.push(root.val);
  helper(root.left, res);
  helper(root.right, res);
};

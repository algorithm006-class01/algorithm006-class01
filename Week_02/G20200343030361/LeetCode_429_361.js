// method 1
const levelOrder = root => {
  let res = [];

  const helper = (node, level) => {
    if (res.length == level) res.push([]);

    res[level].push(node.val);

    node.children.forEach(cNode => helper(cNode, level + 1));
  };

  if (root) helper(root, 0);

  return res;
};

// method 2
// var levelOrder = function(root) {
//   let res = [];
//   if (!root) return res;
//   let currStack = [root];

//   while (currStack.length > 0) {
//     let curr = [];
//     let nextLevel = [];
//     currStack.forEach((node) => {
//       if (!isNaN(node.val)) curr.push(node.val);
//       if (node.children.length > 0) nextLevel = nextLevel.concat(node.children);
//     })

//     res.push(curr);
//     currStack = nextLevel;
//   }

//   return res;
// };

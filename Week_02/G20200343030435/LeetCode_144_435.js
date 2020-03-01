let preorderTraversal = root => {
  return root
    ? [
        root.val,
        ...preorderTraversal(root.left),
        ...preorderTraversal(root.right)
      ]
    : [];
};

// https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

var buildTree = function(preOrder, inOrder) {
    
    if(inOrder.length == 0 && preOrder.length == 0) {
        return null;
    };

    let root = {};
    root.val = preOrder[0];

    let rootIdxInOrder = inOrder.indexOf(root.val);

    let leftTreeInOrder = inOrder.slice(0, rootIdxInOrder);
    let leftTreePreOrder = preOrder.slice(1, leftTreeInOrder.length + 1);
 
    root.left = buildTree(leftTreePreOrder, leftTreeInOrder);

   
    let rightTreeInOrder = inOrder.slice(rootIdxInOrder + 1);
    let rightTreePreOrder = preOrder.slice(rootIdxInOrder + 1);
    
    root.right  = buildTree(rightTreePreOrder, rightTreeInOrder);

    return root;
};
// construct-binary-tree-from-preorder-and-inorder-traversal

var buildTree = function(preorder, inorder) {
    if (preorder.length == 0) {
        return null;
    }

    var root = new TreeNode(preorder[0]);
     
    var mid;
    for (var i=0; i< inorder.length; i++) {
        if (preorder[0] == inorder[i]) mid = i;
    }

    root.left = buildTree(preorder.slice(1,mid+1), inorder.slice(0,mid));
    root.right = buildTree(preorder.slice(mid+1, preorder.length), inorder.slice(mid+1, inorder.length));

    return root
};